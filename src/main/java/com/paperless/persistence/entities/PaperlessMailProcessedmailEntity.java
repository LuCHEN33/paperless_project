package com.paperless.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


@Getter
@Setter
@Entity
@Table(name = "paperless_mail_processedmail")
public class PaperlessMailProcessedmailEntity {

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

    @Column(name = "folder", nullable = false, length = 256)
    private String folder;

    @Column(name = "uid", nullable = false, length = 256)
    private String uid;

    @Column(name = "subject", nullable = false, length = 256)
    private String subject;

    @Column(name = "received", nullable = false)
    private OffsetDateTime received;

    @Column(name = "processed", nullable = false)
    private OffsetDateTime processed;

    @Column(name = "status", nullable = false, length = 256)
    private String status;

    @Column(name = "error", columnDefinition = "TEXT")
    private String error;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUserEntity owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rule_id", nullable = false)
    private PaperlessMailMailruleEntity rule;

}

