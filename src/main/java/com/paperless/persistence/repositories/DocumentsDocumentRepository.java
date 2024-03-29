package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.DocumentsDocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsDocumentRepository extends JpaRepository<DocumentsDocumentEntity,Integer> {
}
