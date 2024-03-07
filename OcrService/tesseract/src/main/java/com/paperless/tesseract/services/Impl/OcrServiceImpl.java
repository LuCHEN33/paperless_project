package com.paperless.tesseract.services.Impl;

import com.paperless.tesseract.persistence.entities.DocumentsDocumentEntity;
import com.paperless.tesseract.services.DocumentService;
import com.paperless.tesseract.services.ElasticSearchService;
import com.paperless.tesseract.services.OcrService;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.errors.MinioException;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.OffsetDateTime;

@Service
@Slf4j
public class OcrServiceImpl implements OcrService {
    // Dependency injection of MinioClient, DocumentService, and ElasticSearchService
    private final MinioClient minioClient;
    private final DocumentService documentService;
    private final ElasticSearchService elasticSearchService;

    @Autowired
    public OcrServiceImpl(MinioClient minioClient, DocumentService documentService, ElasticSearchService elasticSearchService) {
        this.minioClient = minioClient;
        this.documentService = documentService;
        this.elasticSearchService = elasticSearchService;
    }

    @Override
    public void performOCR(String id) {
        try {
            // Retrieve document from the database
            DocumentsDocumentEntity document = documentService.getById(id);
            if (document != null) {
                // Fetch PDF data from Minio storage
                byte[] pdfData = fetchDocumentDataFromMinio(document.getStoragePath().getPath());
                // Convert the first page of the PDF to an image
                BufferedImage image = convertPdfToImage(pdfData);
                // Extract text from the converted image using OCR
                String extractedText = extractTextFromImage(image);
                // Update the document with extracted text and modification time
                updateDocumentWithExtractedText(document, extractedText);
            }
        } catch (Exception e) {
            log.error("Error performing OCR: {}", e.getMessage(), e);
        }
    }

    // Fetches document data from Minio using the document's storage path
    private byte[] fetchDocumentDataFromMinio(String storagePath) throws MinioException, IOException, NoSuchAlgorithmException, InvalidKeyException {
        String[] pathComponents = storagePath.split("/", 2);
        if (pathComponents.length != 2) return null;

        try (InputStream stream = minioClient.getObject(GetObjectArgs.builder()
                .bucket(pathComponents[0])
                .object(pathComponents[1])
                .build())) {
            return stream.readAllBytes();
        }
    }

    // Converts the first page of a PDF to an image using PDFBox
    private BufferedImage convertPdfToImage(byte[] pdfData) throws IOException {
        try (PDDocument document = PDDocument.load(pdfData)) {
            PDFRenderer renderer = new PDFRenderer(document);
            return renderer.renderImage(0);
        }
    }

    // Extracts text from the image using Tesseract OCR
    private String extractTextFromImage(BufferedImage image) {
        ITesseract tesseract = new Tesseract();
        try {
            return tesseract.doOCR(image);
        } catch (Exception e) {
            log.error("Error extracting text from image: {}", e.getMessage(), e);
            return null;
        }
    }

    // Updates the document entity with the extracted text and current time, then saves it
    private void updateDocumentWithExtractedText(DocumentsDocumentEntity document, String text) {
        document.setContent(text);
        document.setModified(OffsetDateTime.now());
        documentService.saveDocument(document);
        try {
            // Index the updated document in Elasticsearch
            elasticSearchService.indexDocument(document);
        } catch (IOException e) {
            log.error("Error indexing document: {}", e.getMessage(), e);
        }
    }
}
