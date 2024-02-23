package com.paperless.services;

import com.paperless.persistence.entities.DocumentsDocumentEntity;
import co.elastic.clients.elasticsearch._types.Result;


import java.io.IOException;
import java.util.Optional;

public interface SearchIndexService {
    Result indexDocument(DocumentsDocumentEntity documentsDocumentEntity) throws IOException;

    Optional<DocumentsDocumentEntity> getDocumentById(int id);
}
