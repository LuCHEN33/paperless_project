package com.paperless.persistence.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "paperless_mail_mailaccount", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class PaperlessMailMailaccountEntity {

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

    @Column(name = "name", nullable = false, length = 256, unique = true)
    private String name;

    @Column(name = "imap_server", nullable = false, length = 256)
    private String imapServer;

    @Column(name = "imap_port")
    private Integer imapPort;

    @Column(name = "imap_security", nullable = false)
    private Integer imapSecurity;

    @Column(name = "username", nullable = false, length = 256)
    private String username;

    @Column(name = "password", nullable = false, length = 2048)
    private String password;

    @Column(name = "character_set", nullable = false, length = 256)
    private String characterSet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUserEntity owner;

    @Column(name = "is_token", nullable = false)
    private Boolean isToken;

}

