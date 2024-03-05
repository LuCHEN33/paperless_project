package com.paperless.tesseract.persistence.repositories;

import com.paperless.tesseract.persistence.entities.DocumentsSavedViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsSavedViewRepository extends JpaRepository<DocumentsSavedViewEntity,Integer> {
}
