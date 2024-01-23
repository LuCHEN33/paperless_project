package com.paperless.services.mapper;

import com.paperless.persistence.entities.DocumentsDocumentEntity;
import com.paperless.services.dto.DocumentDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DocumentMapperTest {
    @InjectMocks
    private DocumentMapper documentMapper = Mappers.getMapper(DocumentMapper.class);

    @Test
    void testDtoToEntity() {
        // Arrange
        DocumentDTO dto = new DocumentDTO();
        // Set properties of dto as needed

        // Act
        DocumentsDocumentEntity entity = documentMapper.dtoToEntity(dto);

        // Assert
        assertEquals(dto.getId(), entity.getId());
        // Add more assertions here for other properties
    }

    @Test
    void testEntityToDto() {
        // Arrange
        DocumentsDocumentEntity entity = new DocumentsDocumentEntity();
        // Set properties of entity as needed

        // Act
        DocumentDTO dto = documentMapper.entityToDto(entity);

        // Assert
        assertEquals(entity.getId(), dto.getId());
        // Add more assertions here for other properties
    }


}
