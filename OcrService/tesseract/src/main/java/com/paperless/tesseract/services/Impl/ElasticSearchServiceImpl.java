package com.paperless.tesseract.services.Impl;

import com.paperless.tesseract.dto.DocumentDTO;
import com.paperless.tesseract.persistence.entities.DocumentsDocumentEntity;
import com.paperless.tesseract.services.ElasticSearchService;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.Result;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.paperless.tesseract.dto.DocumentDTO;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Primary
@Slf4j
public class ElasticSearchServiceImpl implements ElasticSearchService {

    private final ElasticsearchClient esClient;


    @Autowired
    public ElasticSearchServiceImpl(ElasticsearchClient esClient) throws IOException {
        this.esClient = esClient;

        // Ensure the index for images exists
        if (!esClient.indices().exists(
                i -> i.index("doc-index")
        ).value()) {
            // Create the index if it does not exist
            esClient.indices().create(c -> c
                    .index("doc-index")
            );
        }
    }

    @Override
    public Result indexDocument(DocumentsDocumentEntity document) throws IOException {
        return null;
    }
/*
    @Override
    public Result indexDocument(DocumentsDocumentEntity Document) throws IOException {
        // Convert Document entity to DTO
        DocumentDTO documentdto = DocumentDTO.builder()
                .id(Document.getId())
                .title(JsonNullable.of(Document.getTitle()))
                .tags(JsonNullable.of(Document.getTags()))
                .build();

        // Index the document
        IndexResponse response = esClient.index(i -> i
                .index("doc-index")
                .id(documentdto.getId().toString())
                .document(documentdto)
        );

        // Return the result of the indexing operation
        return response.result();
    }


*/

}