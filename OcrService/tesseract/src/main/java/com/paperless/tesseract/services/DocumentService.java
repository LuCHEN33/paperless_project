package com.paperless.tesseract.services;

import com.paperless.tesseract.persistence.entities.DocumentsDocumentEntity;

import java.util.Optional;

public interface DocumentService {
    void saveDocument(DocumentsDocumentEntity document);

    Optional<DocumentsDocumentEntity> getById(String id);
}
