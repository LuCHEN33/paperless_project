package com.paperless.persistence.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "documents_savedview")
public class DocumentsSavedViewEntity {

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

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "show_on_dashboard", nullable = false)
    private Boolean showOnDashboard;

    @Column(name = "show_in_sidebar", nullable = false)
    private Boolean showInSidebar;

    @Column(name = "sort_field", length = 128)
    private String sortField;

    @Column(name = "sort_reverse", nullable = false)
    private Boolean sortReverse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private AuthUserEntity owner;
}

