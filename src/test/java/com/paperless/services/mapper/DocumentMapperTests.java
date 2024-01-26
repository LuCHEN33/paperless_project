package com.paperless.services.mapper;

import com.paperless.persistence.entities.DocumentsDocumentEntity;
import com.paperless.services.dto.DocumentDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DocumentMapperTest {
    @InjectMocks
    private DocumentMapper documentMapper = Mappers.getMapper(DocumentMapper.class);

    @Test
    void testDtoToEntity() {
        // Arrange
        DocumentDTO dto = new DocumentDTO();

        // Set properties of dto
        dto.setTitle(JsonNullable.of("Titel"));
        dto.setAdded(OffsetDateTime.now());
        dto.setCreated(OffsetDateTime.now());
        dto.setModified(OffsetDateTime.now());

        // Act
        DocumentsDocumentEntity entity = documentMapper.dtoToEntity(dto);

        // Assert
        assertEquals(dto.getTitle().orElse(null), entity.getTitle());
        assertEquals(dto.getAdded(), entity.getAdded());
        assertEquals(dto.getCreated(), entity.getCreated());
        assertEquals(dto.getModified(), entity.getModified());
    }

    @Test
    void testEntityToDto() {
        // Arrange
        DocumentsDocumentEntity entity = new DocumentsDocumentEntity();

        // Set properties of entity
        entity.setTitle("Titel");
        entity.setAdded(OffsetDateTime.now());
        entity.setCreated(OffsetDateTime.now());
        entity.setModified(OffsetDateTime.now());
        entity.setArchivedFileName("archived file name");
        entity.setOriginalFileName("original file name");
        entity.setContent("this is supposed to be a lot of content right here");

        // Act
        DocumentDTO dto = documentMapper.entityToDto(entity);

        // Assert
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getAdded(), dto.getAdded());
        assertEquals(entity.getCreated(), dto.getCreated());
        assertEquals(entity.getModified(), dto.getModified());
        assertEquals(entity.getArchivedFileName(), dto.getArchivedFileName().orElse(null));
        assertEquals(entity.getOriginalFileName(), dto.getOriginalFileName().orElse(null));
        assertEquals(entity.getContent(), dto.getContent().orElse(null));
    }


}
