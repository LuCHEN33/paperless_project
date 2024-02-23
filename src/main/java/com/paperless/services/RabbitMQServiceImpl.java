package com.paperless.services;

import co.elastic.clients.elasticsearch._types.Result;
import com.paperless.configuration.RabbitMQConfig;
import com.paperless.misc.RetrievedObject;
import com.paperless.persistence.entities.DocumentsDocumentEntity;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Optional;

@Service
@Slf4j
public class RabbitMQServiceImpl implements RabbitMQService{

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQService.class);

    private final MinIOService minIOService;
    private final DocumentService documentService;

    private final OcrService ocrService;

    private final SearchIndexService searchIndexService;

    // private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQServiceImpl(MinIOService minIOService, DocumentService documentService, OcrService ocrService, SearchIndexService searchIndexService) {
        this.minIOService = minIOService;
        this.documentService = documentService;
        this.ocrService = ocrService;
        this.searchIndexService = searchIndexService;
    }

   /* public void sendToOcrDocumentInQueue(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.MESSAGE_IN_QUEUE, message);
    }*/

    @Override
    public void sendToOcrDocumentInQueue(String message) {

    }

    @RabbitListener(queues = RabbitMQConfig.MESSAGE_IN_QUEUE)
    public void receiveMessage(String message) {
        LOGGER.info("Message received: {}", message);

        RetrievedObject retrievedObject = minIOService.retrieveObject(message);
        Path path = retrievedObject.path();
        String objectId = retrievedObject.objectId();
        String extractedText = null;

        try {
            extractedText = ocrService.executeOCR(path.toFile());
            String title = documentService.updateContent(extractedText, Long.parseLong(objectId));

            // Assuming the document entity or similar object to index
            DocumentsDocumentEntity document = new DocumentsDocumentEntity();
            document.setId((int) Long.parseLong(objectId));
            document.setContent(extractedText);
            document.setTitle(title);

            // Index the document
            Result indexResult = searchIndexService.indexDocument(document);
            LOGGER.info("Document indexed successfully: {}", objectId);

            // Now verify if the document has been stored in Elasticsearch
            Optional<DocumentsDocumentEntity> indexedDocumentOpt = searchIndexService.getDocumentById(Integer.parseInt(objectId));
            if (indexedDocumentOpt.isPresent()) {
                DocumentsDocumentEntity indexedDocument = indexedDocumentOpt.get();
                // Perform any additional checks if necessary, for example, on the content
                if (extractedText.equals(indexedDocument.getContent())) {
                    LOGGER.info("Verified that the document content is stored correctly in Elasticsearch for ID: {}", objectId);
                } else {
                    LOGGER.warn("The document content in Elasticsearch may differ for ID: {}", objectId);
                }
            } else {
                LOGGER.error("Document not found in Elasticsearch for ID: {}", objectId);
            }

        } catch (Exception e) {
            LOGGER.error("Error while executing OCR or indexing document", e);
        }

        LOGGER.info("Extracted text: {}", extractedText);
    }

}
