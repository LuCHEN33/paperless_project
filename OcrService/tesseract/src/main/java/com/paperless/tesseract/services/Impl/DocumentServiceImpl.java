package com.paperless.tesseract.services.Impl;


import com.paperless.tesseract.persistence.entities.DocumentsDocumentEntity;
import com.paperless.tesseract.persistence.repositories.DocumentsDocumentRepository;
import com.paperless.tesseract.services.DocumentService;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentsDocumentRepository documentsDocumentRepository;

    public DocumentServiceImpl(DocumentsDocumentRepository documentsDocumentRepository) {
        this.documentsDocumentRepository = documentsDocumentRepository;
    }

    @Override
    public void saveDocument(DocumentsDocumentEntity document) {
        documentsDocumentRepository.save(document);
    }

    @Override
    public DocumentsDocumentEntity getById(String id) {
        // Using the repository's findById method. If the document is not found, return null.
        return documentsDocumentRepository.findById(Integer.parseInt(id)).orElse(null);
    }
}

