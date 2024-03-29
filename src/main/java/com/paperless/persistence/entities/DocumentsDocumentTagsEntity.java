package com.paperless.persistence.entities;

import javax.persistence.*;

@Entity
public class DocumentsDocumentTagsEntity {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", nullable = false)
    private DocumentsDocumentEntity document;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private DocumentsTagEntity tag;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public DocumentsDocumentEntity getDocument() {
        return document;
    }

    public void setDocument(final DocumentsDocumentEntity document) {
        this.document = document;
    }

    public DocumentsTagEntity getTag() {
        return tag;
    }

    public void setTag(final DocumentsTagEntity tag) {
        this.tag = tag;
    }

}
