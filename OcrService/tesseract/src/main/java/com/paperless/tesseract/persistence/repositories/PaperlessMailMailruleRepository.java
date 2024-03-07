package com.paperless.tesseract.persistence.repositories;

import com.paperless.tesseract.persistence.entities.PaperlessMailMailruleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperlessMailMailruleRepository extends JpaRepository<PaperlessMailMailruleEntity,Integer> {
}
