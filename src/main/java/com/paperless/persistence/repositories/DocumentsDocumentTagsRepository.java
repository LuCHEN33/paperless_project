package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.DocumentsDocumentTagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsDocumentTagsRepository extends JpaRepository<DocumentsDocumentTagsEntity,Integer> {
}
