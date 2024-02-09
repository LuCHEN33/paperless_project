package com.paperless.services;

import co.elastic.clients.elasticsearch._types.Result;
import com.paperless.persistence.entities.DocumentsDocumentEntity;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ElasticSearchService {

    List<DocumentsDocumentEntity> findDocs(String searchText) throws IOException ;
}
