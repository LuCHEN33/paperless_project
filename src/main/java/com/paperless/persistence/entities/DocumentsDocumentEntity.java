package com.paperless.persistence.entities;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;



@Entity
public class DocumentsDocumentEntity {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer id;

    @Column(nullable = false, length = 128)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String content;

    @Column(nullable = false)
    private OffsetDateTime created;

    @Column(nullable = false)
    private OffsetDateTime modified;

    @Column(nullable = false, length = 32)
    private String checksum;

    @Column(nullable = false)
    private OffsetDateTime added;

    @Column(nullable = false, length = 11)
    private String storageType;

    @Column(length = 1024)
    private String filename;

    @Column
    private Integer archiveSerialNumber;

    @Column(nullable = false, length = 256)
    private String mimeType;

    @Column(length = 32)
    private String archiveChecksum;

    @Column(length = 1024)
    private String archivedFileName;

    @Column(length = 1024)
    private String originalFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "correspondent_id")
    private DocumentsCorrespondentEntity correspondent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id")
    private DocumentsDocumentTypeEntity documentType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "storage_path_id")
    private DocumentsStoragePathEntity storagePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUserEntity owner;

    @OneToMany(mappedBy = "document")
    private Set<DocumentsNoteEntity> notes;

    @OneToMany(mappedBy = "document")
    private Set<DocumentsDocumentTagsEntity> tags;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getContent() {return content;}

    public void setContent(String content) {this.content = content;}

    public OffsetDateTime getCreated() {return created;}

    public void setCreated(OffsetDateTime created) {this.created = created;}

    public OffsetDateTime getModified() {return modified;}

    public void setModified(OffsetDateTime modified) {this.modified = modified;}

    public String getChecksum() {return checksum;}

    public void setChecksum(String checksum) {this.checksum = checksum;}

    public OffsetDateTime getAdded() {return added;}

    public void setAdded(OffsetDateTime added) {this.added = added;}

    public String getStorageType() {return storageType;}

    public void setStorageType(String storageType) {this.storageType = storageType;}

    public String getFilename() {return filename;}

    public void setFilename(String filename) {this.filename = filename;}

    public Integer getArchiveSerialNumber() {return archiveSerialNumber;}

    public void setArchiveSerialNumber(Integer archiveSerialNumber) {this.archiveSerialNumber = archiveSerialNumber;}

    public String getMimeType() {return mimeType;}

    public void setMimeType(String mimeType) {this.mimeType = mimeType;}

    public String getArchiveChecksum() {return archiveChecksum;}

    public void setArchiveChecksum(String archiveChecksum) {this.archiveChecksum = archiveChecksum;}

    public String getArchivedFileName() {return archivedFileName;}

    public void setArchivedFileName(String archivedFileName) {this.archivedFileName = archivedFileName;}

    public String getOriginalFileName() {return originalFileName;}

    public void setOriginalFileName(String originalFileName) {this.originalFileName = originalFileName;}

    public DocumentsCorrespondentEntity getCorrespondent() {return correspondent;}

    public void setCorrespondent(DocumentsCorrespondentEntity correspondent) {this.correspondent = correspondent;}

    public DocumentsDocumentTypeEntity getDocumentType() {return documentType;}

    public void setDocumentType(DocumentsDocumentTypeEntity documentType) {this.documentType = documentType;}

    public DocumentsStoragePathEntity getStoragePath() {return storagePath;}

    public void setStoragePath(DocumentsStoragePathEntity storagePath) {this.storagePath = storagePath;}

    public AuthUserEntity getOwner() {return owner;}

    public void setOwner(AuthUserEntity owner) {this.owner = owner;}

    public Set<DocumentsNoteEntity> getNotes() {return notes;}

    public Set<DocumentsDocumentTagsEntity> getTags() {return tags;}

    public void setNotes(final Set<DocumentsNoteEntity> notes) {
        this.notes = notes;
    }

    public void setTags(final Set<DocumentsDocumentTagsEntity> tags) {this.tags = tags;}

}

