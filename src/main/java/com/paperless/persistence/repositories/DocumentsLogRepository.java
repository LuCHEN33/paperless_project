package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.DocumentsLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsLogRepository extends JpaRepository<DocumentsLogEntity,Integer> {
}
