package com.paperless.tesseract.persistence.repositories;

import com.paperless.tesseract.persistence.entities.DocumentsStoragePathEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsStoragePathRepository extends JpaRepository<DocumentsStoragePathEntity,Integer> {
}
