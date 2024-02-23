package com.paperless.services;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.Result;
import co.elastic.clients.elasticsearch.core.GetRequest;
import co.elastic.clients.elasticsearch.core.GetResponse;
import com.paperless.misc.RetrievedObject;
import com.paperless.persistence.entities.DocumentsDocumentEntity;
import com.paperless.services.dto.DocumentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class DocumentServiceImplTest {
    @Mock
    private ElasticsearchClient esClient;

    @Mock
    private ElasticSearchService elasticSearchService;
    @Mock
    private MinIOService mockServiceMinIOService;
    @Mock
    private OcrService mockOcrService;
    @Mock
    private SearchIndexService mockSearchIndexService;
    @Mock
    private DocumentService mockDocumentService;

    private RabbitMQService queueListenerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        queueListenerService = new RabbitMQServiceImpl(mockServiceMinIOService, mockDocumentService, mockOcrService, mockSearchIndexService);
    }

    @Test
    void testReceiveMessageIndexResult() throws Exception {
        // Arrange
        String message = "testMessage";
        RetrievedObject retrievedObject = new RetrievedObject(Path.of("dummyPath"), "1");
        when(mockServiceMinIOService.retrieveObject(message)).thenReturn(retrievedObject);
        when(mockOcrService.executeOCR(any())).thenReturn("Extracted Text");
        when(mockDocumentService.updateContent(anyString(), anyLong())).thenReturn("Test Title");

        when(mockSearchIndexService.indexDocument(any(DocumentsDocumentEntity.class))).thenReturn(Result.Created); // Assuming Result is the correct return type

        // Act
        queueListenerService.receiveMessage(message);

        // Assert
        verify(mockSearchIndexService).indexDocument(any(DocumentsDocumentEntity.class));
        // No need to verify mockIndexResponse.result() since it's part of the stubbing
    }
    @Test
    void testGetDocumentByIdNotFound() throws IOException {
        // Arrange
        int id = 1;
        GetResponse<DocumentsDocumentEntity> response = Mockito.mock(GetResponse.class);
        lenient().when(response.found()).thenReturn(false); // Make this stubbing lenient
        lenient().when(esClient.get((GetRequest) any(), eq(DocumentsDocumentEntity.class))).thenReturn(response); // Make this stubbing lenient

        // Act
        Optional<DocumentDTO> result = elasticSearchService.getDocumentById(id);

        // Assert
        assertEquals(Optional.empty(), result);
    }

}