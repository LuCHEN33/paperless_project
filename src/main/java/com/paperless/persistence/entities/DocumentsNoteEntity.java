package com.paperless.persistence.entities;

import javax.persistence.*;
import java.time.OffsetDateTime;



@Entity
public class DocumentsNoteEntity {
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

    @Column(nullable = false, columnDefinition = "text")
    private String note;

    @Column(nullable = false)
    private OffsetDateTime created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    private DocumentsDocumentEntity document;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private AuthUserEntity user;

    public Integer getId() {return id;}

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getNote() {return note;}

    public void setNote(final String note) {
        this.note = note;
    }

    public OffsetDateTime getCreated() {return created;}

    public void setCreated(final OffsetDateTime created) {
        this.created = created;
    }

    public DocumentsDocumentEntity getDocument() {return document;}

    public void setDocument(final DocumentsDocumentEntity document) {
        this.document = document;
    }

    public AuthUserEntity getUser() {return user;}

    public void setUser(final AuthUserEntity user) {
        this.user = user;
    }

}
