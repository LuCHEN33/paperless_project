package com.paperless.persistence.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsDocumentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsDocumentTypeRepository extends JpaRepository<DocumentsDocumentTypeEntity,Integer> {
}
