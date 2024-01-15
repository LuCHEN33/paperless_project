package com.paperless.persistence.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsPaperlessTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsPaperlessTaskRepository extends JpaRepository<DocumentsPaperlessTaskEntity,Integer> {
}
