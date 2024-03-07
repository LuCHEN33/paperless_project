package com.paperless.services.mapper;

import com.paperless.services.dto.DocumentNoteDTO;
import com.paperless.persistence.entities.AuthUserEntity;
import com.paperless.persistence.entities.DocumentsDocumentEntity;
import com.paperless.persistence.entities.DocumentsNoteEntity;
import com.paperless.persistence.repositories.AuthUserRepository;
import com.paperless.persistence.repositories.DocumentsDocumentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DocumentNotesMapperTest {

    @InjectMocks
    private DocumentNotesMapper documentNotesMapper = Mappers.getMapper(DocumentNotesMapper.class);

    @Mock
    private AuthUserRepository authUserRepository;

    @Mock
    private DocumentsDocumentRepository documentsDocumentRepository;

    private DocumentNoteDTO dto;
    private DocumentsNoteEntity entity;

    @BeforeEach
    void setUp() {
        dto = new DocumentNoteDTO();
        dto.setDocument(1);
        dto.setUser(1);
        dto.setCreated(OffsetDateTime.now().toString());

        entity = new DocumentsNoteEntity();
        entity.setDocument(new DocumentsDocumentEntity());
        entity.setUser(new AuthUserEntity());
        entity.setCreated(OffsetDateTime.now());
    }

    @Test
    void testEntityToDto() {
        DocumentNoteDTO resultDto = documentNotesMapper.entityToDto(entity);
        assertEquals(entity.getDocument().getId(), resultDto.getDocument());
        assertEquals(entity.getUser().getId(), resultDto.getUser());
        assertEquals(entity.getCreated().toString(), resultDto.getCreated());
    }
}