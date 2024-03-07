package com.paperless.services.mapper;

import com.paperless.persistence.entities.DocumentsDocumentEntity;
import com.paperless.services.dto.DocumentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    private DocumentDTO dto;
    private DocumentsDocumentEntity entity;

    @BeforeEach
    void setUp() {
        dto = new DocumentDTO();
        dto.setTitle(JsonNullable.of("Title"));
        dto.setAdded(OffsetDateTime.now());
        dto.setCreated(OffsetDateTime.now());
        dto.setModified(OffsetDateTime.now());

        entity = new DocumentsDocumentEntity();
        entity.setTitle("Title");
        entity.setAdded(OffsetDateTime.now());
        entity.setCreated(OffsetDateTime.now());
        entity.setModified(OffsetDateTime.now());
    }

    @Test
    @DisplayName("Test Document mapper DTO to Entity")
    void testDtoToEntity() {
        DocumentsDocumentEntity resultEntity = documentMapper.dtoToEntity(dto);
        assertEquals(dto.getTitle().orElse(null), resultEntity.getTitle());
        assertEquals(dto.getAdded(), resultEntity.getAdded());
        assertEquals(dto.getCreated(), resultEntity.getCreated());
        assertEquals(dto.getModified(), resultEntity.getModified());
    }

    @Test
    @DisplayName("Test Document mapper Entity to DTO")
    void testEntityToDto() {
        DocumentDTO resultDto = documentMapper.entityToDto(entity);
        assertEquals(entity.getTitle(), resultDto.getTitle().orElse(null));
        assertEquals(entity.getAdded(), resultDto.getAdded());
        assertEquals(entity.getCreated(), resultDto.getCreated());
        assertEquals(entity.getModified(), resultDto.getModified());
    }


}
