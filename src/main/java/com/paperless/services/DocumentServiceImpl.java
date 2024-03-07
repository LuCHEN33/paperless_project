package com.paperless.services;

import com.paperless.persistence.entities.DocumentsDocumentEntity;
import com.paperless.persistence.entities.DocumentsStoragePathEntity;
import com.paperless.persistence.repositories.DocumentsDocumentRepository;
import com.paperless.services.dto.DocumentDTO;
import com.paperless.services.dto.okresponse.GetDocument200Response;
import com.paperless.services.dto.okresponse.GetDocuments200Response;
import com.paperless.services.dto.okresponse.UpdateDocument200Response;
import com.paperless.services.dto.update.UpdateDocumentRequest;
import com.paperless.services.mapper.DocumentMapper;
import com.paperless.services.mapper.GetDocument200ResponseMapper;
import com.paperless.services.mapper.UpdateDocument200ResponseMapper;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class DocumentServiceImpl implements DocumentService {

    private final DocumentsDocumentRepository documentsDocumentRepository;
    private final DocumentMapper documentMapper;
    private final GetDocument200ResponseMapper getDocument200ResponseMapper;
    private final UpdateDocument200ResponseMapper updateDocument200ResponseMapper;

    private final MinioClient minioClient;

    private final RabbitMQService rabbitMQService;

    private final ElasticSearchServiceImpl elasticSearchService;


    @Value("${minio.bucketName}")
    private String bucketName;


    @Autowired
    public DocumentServiceImpl(DocumentsDocumentRepository documentsDocumentRepository, DocumentMapper documentMapper, GetDocument200ResponseMapper getDocument200ResponseMapper, UpdateDocument200ResponseMapper updateDocument200ResponseMapper, MinioClient minioClient, RabbitMQService rabbitMQService, ElasticSearchServiceImpl elasticSearchService){
        this.documentsDocumentRepository = documentsDocumentRepository;
        this.documentMapper = documentMapper;
        this.getDocument200ResponseMapper = getDocument200ResponseMapper;
        this.updateDocument200ResponseMapper = updateDocument200ResponseMapper;
        this.minioClient = minioClient;
        this.rabbitMQService = rabbitMQService;
        this.elasticSearchService = elasticSearchService;
    }

    @Override
    public GetDocument200Response getDocument(Integer id, Integer page, Boolean fullPerms) {
        DocumentsDocumentEntity foundEntity =  documentsDocumentRepository.getReferenceById(id);
        log.debug("Document entity retrieved successfully for id: {}", id);
        return getDocument200ResponseMapper.entityToDto(foundEntity);
    }


    @Override
    public void uploadDocument(DocumentDTO documentDTO, MultipartFile file) {
        // Setting timestamps and initializing fields
        documentDTO.setCreated(OffsetDateTime.now());
        documentDTO.setAdded(OffsetDateTime.now());
        documentDTO.setModified(OffsetDateTime.now());
        documentDTO.content("");
        documentDTO.setAdded(OffsetDateTime.now());


        DocumentsDocumentEntity documentToBeSaved = documentMapper.dtoToEntity(documentDTO);

        // Additional entity setup
        documentToBeSaved.setChecksum("checksum");
        documentToBeSaved.setStorageType("pdf");
        documentToBeSaved.setMimeType("pdf");

        // Handling file storage
        String objectName = UUID.randomUUID().toString() + getFileExtension(Objects.requireNonNull(file.getOriginalFilename()));

        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build()
            );
            log.debug("File uploaded to Minio with object name: {}", objectName);

        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException | InvalidResponseException | IOException | NoSuchAlgorithmException | ServerException | XmlParserException e) {
            throw new RuntimeException(e);
        }
        // Setting up storage path entity
        DocumentsStoragePathEntity pathToFile = new DocumentsStoragePathEntity();
        pathToFile.setPath(bucketName + "/" + objectName);
        pathToFile.setName(file.getOriginalFilename());
        pathToFile.setMatch("");
        pathToFile.setMatchingAlgorithm(0);
        pathToFile.setIsInsensitive(false);

        documentToBeSaved.setStoragePath(pathToFile);

        // Sending to queue and saving
        rabbitMQService.sendToOcrDocumentInQueue(documentToBeSaved.getStoragePath().getPath());
        documentsDocumentRepository.save(documentToBeSaved);
        log.debug("Document saved and sent to queue successfully");
    }


    @Override
    public ResponseEntity<GetDocuments200Response> getDocuments(Integer page, Integer pageSize, String query, String ordering, List<Integer> tagsIdAll, Integer documentTypeId, Integer storagePathIdIn, Integer correspondentId, Boolean truncateContent) throws IOException {
        List<DocumentDTO> documentDTOS = new ArrayList<>();

        if(query == null || query.isEmpty()) {
            //find all documents
            for (DocumentsDocumentEntity document : documentsDocumentRepository.findAll()) {
                documentDTOS.add(documentMapper.entityToDto(document));
            }
            log.info("Query was empty. Searching for all documents");
        } else {
            //search with elasticsearch
            for (DocumentsDocumentEntity document : elasticSearchService.findDocs(query)) {
                documentDTOS.add(documentMapper.entityToDto(document));
            }
            log.info("Searching for documents matching '{}'", query);
        }

        GetDocuments200Response sampleResponse = new GetDocuments200Response();
        sampleResponse.setCount(100);
        sampleResponse.setNext(1);
        sampleResponse.setPrevious(1);
        sampleResponse.addAllItem(1);

        for(DocumentDTO documentDTO : documentDTOS) {
            sampleResponse.addResultsItem(documentDTO.toGetDocuments200ResponseResultsInner());
        }
        log.info("Documents fetched successfully.");
        return ResponseEntity.ok(sampleResponse);
    }

    @Override
    public ResponseEntity<UpdateDocument200Response> updateDocument(Integer id, UpdateDocumentRequest updateDocumentRequest) {
        try {
            DocumentsDocumentEntity documentEntity = documentsDocumentRepository.getReferenceById(id);
            documentEntity.updateByUpdateDocumentRequest(updateDocumentRequest);
            documentsDocumentRepository.save(documentEntity);

            log.info("Document with ID {} updated successfully", id);
            UpdateDocument200Response updateDocument200Response = updateDocument200ResponseMapper.entityToDto(documentEntity);
            return ResponseEntity.ok(updateDocument200Response);
        } catch (Exception e) {
            log.error("Error updating document with ID {}: {}", id, e.getMessage());
            throw e;
        }
    }


    private String getFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf(".");
        return (lastDotIndex != -1) ? filename.substring(lastDotIndex) : "";
    }

    @Override
    public void deleteDocument(Integer id) {
        DocumentsDocumentEntity document = documentsDocumentRepository.findById(id).orElse(null);

        if (document != null) {
            documentsDocumentRepository.deleteById(id);
            log.info("Document with ID: {} deleted from database successfully", id);
        } else {
            log.error("Could not delete document from database with ID: " + id);
        }

        try {
            String objectName = document.getStoragePath().getPath();
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .build());
            log.info("Document with object name: {} deleted from MinIO successfully", objectName);
        } catch (Exception e) {
            log.error("Error occurred while deleting document with ID: {}", id, e);
        }

    }

}

