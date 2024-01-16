package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.DocumentsCorrespondentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsCorrespondentRepository extends JpaRepository<DocumentsCorrespondentEntity, Integer> {
}
