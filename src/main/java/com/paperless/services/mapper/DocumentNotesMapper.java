package com.paperless.services.mapper;

import com.paperless.persistence.entities.*;
import com.paperless.persistence.repositories.*;
import com.paperless.services.dto.DocumentNoteDTO;
import org.mapstruct.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class DocumentNotesMapper implements BaseMapper<DocumentsNoteEntity, DocumentNoteDTO> {

    @Autowired
    private AuthUserRepository authUserRepository;
    @Autowired
    private DocumentsDocumentRepository documentsDocumentRepository;

    @Mapping(target = "document", source = "document", qualifiedByName = "documentDto")
    @Mapping(target = "user", source = "user", qualifiedByName = "userDto")
    abstract public DocumentsNoteEntity dtoToEntity(DocumentNoteDTO dto);

    @Mapping(target = "document", source = "document", qualifiedByName = "documentEntity")
    @Mapping(target = "user", source = "user", qualifiedByName = "userEntity")
    abstract public DocumentNoteDTO entityToDto(DocumentsNoteEntity entity);

    @Named("userEntity")
    Integer map(AuthUserEntity user) {
        return user.getId();
    }

    @Named("documentEntity")
    Integer map(DocumentsDocumentEntity document) {
        return document.getId();
    }

    @Named("createdEntity")
    String map(OffsetDateTime created) {return created.toString();}

    @Named("userDto")
    AuthUserEntity mapCorrespondent(Integer value) {
        return authUserRepository.findById(value).orElse(null);
    }

    @Named("documentDto")
    DocumentsDocumentEntity mapDocument(Integer value) {
        return documentsDocumentRepository.findById(value).orElse(null);
    }

}

