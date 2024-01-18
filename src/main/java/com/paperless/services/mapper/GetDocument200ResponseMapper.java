package com.paperless.services.mapper;

import com.paperless.persistence.entities.*;
import com.paperless.services.dto.DocumentNoteDTO;
import com.paperless.services.dto.Permissions;
import com.paperless.persistence.repositories.*;
import com.paperless.services.dto.okresponse.GetDocument200Response;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class GetDocument200ResponseMapper implements BaseMapper<DocumentsDocumentEntity, GetDocument200Response> {
    @Autowired
    private DocumentsCorrespondentRepository documentsCorrespondentRepository;
    @Autowired
    private DocumentsDocumentTypeRepository documentsDocumentTypeRepository;
    @Autowired
    private DocumentsStoragePathRepository documentsStoragePathRepository;
    @Autowired
    private AuthUserRepository authUserRepository;
    @Autowired
    private DocumentsDocumentTagsRepository documentsDocumentTagsRepository;

    @Autowired
    private PermissionsMapper PermissionsMapper;
    @Autowired
    private DocumentNotesMapper documentNotesMapper;

    @Mapping(target = "correspondent", source = "correspondent", qualifiedByName = "correspondentDto")
    @Mapping(target = "documentType", source = "documentType", qualifiedByName = "documentTypeDto")
    @Mapping(target = "storagePath", source = "storagePath", qualifiedByName = "storagePathDto")
    @Mapping(target = "tags", source = "tags", qualifiedByName = "tagsDto")
    @Mapping(target = "archiveSerialNumber", source = "archiveSerialNumber", qualifiedByName = "archiveSerialNumberDto")
    @Mapping(target = "owner", source = "owner", qualifiedByName = "ownerDto")
    @Mapping(target = "notes", source = "notes", qualifiedByName = "notesDto")
    abstract public DocumentsDocumentEntity dtoToEntity(GetDocument200Response dto);

    @Mapping(target = "correspondent", source = "correspondent", qualifiedByName = "correspondentEntity")
    @Mapping(target = "documentType", source = "documentType", qualifiedByName = "documentTypeEntity")
    @Mapping(target = "storagePath", source = "storagePath", qualifiedByName = "storagePathEntity")
    @Mapping(target = "tags", source = "tags", qualifiedByName = "tagsEntity")
    @Mapping(target = "createdDate", source = "created", qualifiedByName = "createdToCreatedDate")
    @Mapping(target = "owner", source = "owner", qualifiedByName = "ownerEntity")
    @Mapping(target = "permissions", source = "owner", qualifiedByName = "permissionsEntity")
    @Mapping(target = "notes", source = "notes", qualifiedByName = "notesEntity")
    abstract public GetDocument200Response entityToDto(DocumentsDocumentEntity entity);

    @Named("correspondentEntity")
    Integer map(DocumentsCorrespondentEntity correspondent) {
        if(correspondent == null) return null;

        return correspondent.getId();
    }

    @Named("documentTypeEntity")
    Integer map(DocumentsDocumentTypeEntity documentType) {
        if(documentType == null) return null;
        return documentType.getId();
    }

    @Named("storagePathEntity")
    Integer map(DocumentsStoragePathEntity storagePath) {
        if(storagePath == null) return null;
        return storagePath.getId();
    }

    @Named("ownerEntity")
    Integer map(AuthUserEntity owner) {
        if(owner == null) return null;

        return owner.getId();
    }

    @Named("tagsEntity")
    List<Integer> map(Set<DocumentsDocumentTagsEntity> tags) {
        if(tags == null) return null;
        return tags.stream().map( tag->(int)tag.getId() ).toList();
    }

    @Named("permissionsEntity")
    Permissions mapPermissions(AuthUserEntity owner) {
        if(owner == null) return null;
        return PermissionsMapper.entityToDto(owner);
    }

    @Named("notesEntity")
    List<DocumentNoteDTO> mapNotes(Set<DocumentsNoteEntity> notes) {
        if(notes == null) return null;
        return notes.stream().map( note->documentNotesMapper.entityToDto(note) ).toList();
    }

    // map created to createdDate (Date without the time)
    @Named("createdToCreatedDate")
    OffsetDateTime mapCreatedDate(OffsetDateTime value) {
        return value!=null ? value.withOffsetSameInstant(ZoneOffset.UTC).toLocalDate().atStartOfDay().atOffset(ZoneOffset.UTC) : null;
    }

    @Named("correspondentDto")
    DocumentsCorrespondentEntity mapCorrespondent(Integer value) {
        if(value == null) return null;
        return documentsCorrespondentRepository.findById(value).orElse(null);
    }

    @Named("documentTypeDto")
    DocumentsDocumentTypeEntity mapDocumentType(Integer value) {
        if(value == null) return null;

        return documentsDocumentTypeRepository.findById(value).orElse(null);
    }

    @Named("storagePathDto")
    DocumentsStoragePathEntity mapStoragePath(Integer value) {
        if(value == null) return null;
        return documentsStoragePathRepository.findById(value).orElse(null);
    }

    @Named("ownerDto")
    AuthUserEntity mapOwner(Integer value) {
        if(value == null) return null;
        return authUserRepository.findById(value).orElse(null);
    }

    @Named("tagsDto")
    Set<DocumentsDocumentTagsEntity> mapDocTag(List<Integer> value) {
        if(value == null) return null;
        return new HashSet<DocumentsDocumentTagsEntity>(documentsDocumentTagsRepository.findAllById(value));
    }

    @Named("archiveSerialNumberDto")
    Integer mapArchiveSerialNumber(String value) {
        if(value==null || value.isEmpty()) return null;
        return Integer.parseInt(value);
    }

    @Named("notesDto")
    Set<DocumentsNoteEntity> mapNotes(List<DocumentNoteDTO> value) {
        if(value==null || value.isEmpty()) return null;

        HashSet<DocumentsNoteEntity> notes = new HashSet<DocumentsNoteEntity>();

        for(DocumentNoteDTO note : value) {
            notes.add(documentNotesMapper.dtoToEntity(note));
        }

        return notes;
    }

}
