package com.paperless.tesseract.persistence.repositories;

import com.paperless.tesseract.persistence.entities.PaperlessMailMailruleAssignTagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperlessMailMailruleAssignTagsRepository extends JpaRepository<PaperlessMailMailruleAssignTagsEntity,Integer> {
}
