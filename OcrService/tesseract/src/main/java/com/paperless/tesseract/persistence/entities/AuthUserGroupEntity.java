package com.paperless.tesseract.persistence.entities;


import javax.persistence.*;
import java.util.Set;


@Entity
public class AuthUserGroupEntity {

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

    @Column(nullable = false, length = 150)
    private String name;

    @OneToMany(mappedBy = "group")
    private Set<AuthGroupEntity> groupUserGroups;

    public Set<AuthGroupEntity> getGroupUserGroups() {
        return groupUserGroups;
    }

    public void setGroupUserGroups(Set<AuthGroupEntity> groupUserGroups) {
        this.groupUserGroups = groupUserGroups;
    }

    public Set<AuthGroupPermissionsEntity> getGroupGroupPermissions() {
        return groupGroupPermissions;
    }

    public void setGroupGroupPermissions(Set<AuthGroupPermissionsEntity> groupGroupPermissions) {
        this.groupGroupPermissions = groupGroupPermissions;
    }

    @OneToMany(mappedBy = "group")
    private Set<AuthGroupPermissionsEntity> groupGroupPermissions;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}

