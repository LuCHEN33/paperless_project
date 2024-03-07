package com.paperless.services;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import com.paperless.persistence.entities.DocumentsDocumentEntity;
import com.paperless.persistence.repositories.DocumentsDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ElasticSearchServiceImpl implements ElasticSearchService {
    private final ElasticsearchClient esClient;
    private final DocumentsDocumentRepository docRepo;
    private final Logger log = LoggerFactory.getLogger(ElasticSearchServiceImpl.class);

    @Autowired
    public ElasticSearchServiceImpl(ElasticsearchClient esClient, DocumentsDocumentRepository docRepo) {
        this.esClient = esClient;
        this.docRepo = docRepo;
    }

    public List<DocumentsDocumentEntity> findDocs(String searchText) throws IOException {
        List<DocumentsDocumentEntity> resultEntities = new ArrayList<>();
        try {
            SearchResponse<DocumentsDocumentEntity> response = esClient.search(s -> s
                    .index("doc-index")
                    .query(q -> q
                            .match(m -> m
                                    .field("titel")
                                    .query(searchText)
                            )
                    ), DocumentsDocumentEntity.class);

            long hitsCount = response.hits().total().value();
            if (hitsCount > 0) {
                log.info("Found {} documents", hitsCount);
                for (Hit<DocumentsDocumentEntity> hit : response.hits().hits()) {
                    DocumentsDocumentEntity docEntity = hit.source(); // Directly get the source if it contains the full entity
                    if (docEntity != null) {
                        resultEntities.add(docEntity);
                    } else {
                        // Optionally handle the case where the document source is null
                        // This might involve fetching the document by ID if necessary
                        Optional<DocumentsDocumentEntity> fetchedDoc = docRepo.findById(Integer.parseInt(hit.id()));
                        fetchedDoc.ifPresent(resultEntities::add);
                    }
                }
            } else {
                log.info("No documents found for '{}'", searchText);
            }
        } catch (Exception e) {
            log.error("Error searching documents: ", e);
        }

        return resultEntities;
    }
}


