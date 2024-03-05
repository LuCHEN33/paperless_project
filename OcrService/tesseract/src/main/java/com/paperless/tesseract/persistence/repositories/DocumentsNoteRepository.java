package com.paperless.tesseract.persistence.repositories;

import com.paperless.tesseract.persistence.entities.DocumentsNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsNoteRepository extends JpaRepository<DocumentsNoteEntity,Integer> {
}
