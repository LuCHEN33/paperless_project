package com.paperless.persistence.entities;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.time.OffsetDateTime;
import java.util.Set;

@Entity
public class AuthUserEntity {

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
    private String password;

    @Column
    private OffsetDateTime lastLogin;

    @Column(nullable = false)
    private Boolean isSuperuser;

    @Column(nullable = false, length = 150)
    private String username;

    @Column(nullable = false, length = 150)
    private String firstName;

    @Column(nullable = false, length = 150)
    private String lastName;

    @Column(nullable = false, length = 254)
    private String email;

    @Column(nullable = false)
    private Boolean isStaff;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private OffsetDateTime dateJoined;

    @OneToMany(mappedBy = "user")
    private Set<AuthGroupEntity> userGroups;

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsCorrespondentEntity> correspondents;

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsDocumentTypeEntity> documentTypes;

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsStoragePathEntity> storagePaths;

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsTagEntity> documentsTags;

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsDocumentEntity> documents;

    @OneToMany(mappedBy = "user")
    private Set<DocumentsNoteEntity> documentsNotes;

    @OneToMany(mappedBy = "user")
    private Set<DocumentsUISettingsEntity> uiSettings;

    @OneToMany(mappedBy = "owner")
    private Set<DocumentsSavedViewEntity> savedViews;

    @OneToMany(mappedBy = "owner")
    private Set<PaperlessMailMailaccountEntity> mailAccounts;

    public Set<DocumentsUISettingsEntity> getUiSettings() {
        return uiSettings;
    }

    public void setUiSettings(Set<DocumentsUISettingsEntity> uiSettings) {
        this.uiSettings = uiSettings;
    }

    public Set<DocumentsSavedViewEntity> getSavedViews() {
        return savedViews;
    }

    public void setSavedViews(Set<DocumentsSavedViewEntity> savedViews) {
        this.savedViews = savedViews;
    }

    public Set<PaperlessMailMailaccountEntity> getMailAccounts() {
        return mailAccounts;
    }

    public void setMailAccounts(Set<PaperlessMailMailaccountEntity> mailAccounts) {
        this.mailAccounts = mailAccounts;
    }

    public Set<PaperlessMailMailruleEntity> getMailRules() {
        return mailRules;
    }

    public void setMailRules(Set<PaperlessMailMailruleEntity> mailRules) {
        this.mailRules = mailRules;
    }

    public Set<AuthUserUserPermissionsEntity> getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(Set<AuthUserUserPermissionsEntity> userPermissions) {
        this.userPermissions = userPermissions;
    }

    public Set<AuthtokenTokenEntity> getAuthTokens() {
        return authTokens;
    }

    public void setAuthTokens(Set<AuthtokenTokenEntity> authTokens) {
        this.authTokens = authTokens;
    }

    public Set<PaperlessMailProcessedmailEntity> getProcessedMails() {
        return processedMails;
    }

    public void setProcessedMails(Set<PaperlessMailProcessedmailEntity> processedMails) {
        this.processedMails = processedMails;
    }

    @OneToMany(mappedBy = "owner")
    private Set<PaperlessMailMailruleEntity> mailRules;

    @OneToMany(mappedBy = "user")
    private Set<AuthUserUserPermissionsEntity> userPermissions;

    @OneToMany(mappedBy = "user")
    private Set<AuthtokenTokenEntity> authTokens;

    @OneToMany(mappedBy = "owner")
    private Set<PaperlessMailProcessedmailEntity> processedMails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public OffsetDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(OffsetDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getSuperuser() {
        return isSuperuser;
    }

    public void setSuperuser(Boolean superuser) {
        isSuperuser = superuser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStaff() {
        return isStaff;
    }

    public void setStaff(Boolean staff) {
        isStaff = staff;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public OffsetDateTime getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(OffsetDateTime dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Set<AuthGroupEntity> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<AuthGroupEntity> userGroups) {
        this.userGroups = userGroups;
    }

    public Set<DocumentsCorrespondentEntity> getCorrespondents() {
        return correspondents;
    }

    public void setCorrespondents(Set<DocumentsCorrespondentEntity> correspondents) {
        this.correspondents = correspondents;
    }

    public Set<DocumentsDocumentTypeEntity> getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(Set<DocumentsDocumentTypeEntity> documentTypes) {
        this.documentTypes = documentTypes;
    }

    public Set<DocumentsStoragePathEntity> getStoragePaths() {
        return storagePaths;
    }

    public void setStoragePaths(Set<DocumentsStoragePathEntity> storagePaths) {
        this.storagePaths = storagePaths;
    }

    public Set<DocumentsTagEntity> getDocumentsTags() {
        return documentsTags;
    }

    public void setDocumentsTags(Set<DocumentsTagEntity> documentsTags) {
        this.documentsTags = documentsTags;
    }

    public Set<DocumentsDocumentEntity> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<DocumentsDocumentEntity> documents) {
        this.documents = documents;
    }

    public Set<DocumentsNoteEntity> getDocumentsNotes() {
        return documentsNotes;
    }

    public void setDocumentsNotes(Set<DocumentsNoteEntity> documentsNotes) {
        this.documentsNotes = documentsNotes;
    }
}