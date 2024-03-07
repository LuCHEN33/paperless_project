package com.paperless.tesseract.services;

import co.elastic.clients.elasticsearch._types.Result;
import com.paperless.tesseract.persistence.entities.DocumentsDocumentEntity;

import java.io.IOException;

public interface ElasticSearchService {
    Result indexDocument(DocumentsDocumentEntity document) throws IOException;
}
