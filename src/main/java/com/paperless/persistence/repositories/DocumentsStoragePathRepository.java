package com.paperless.persistence.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsStoragePathEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsStoragePathRepository extends JpaRepository<DocumentsStoragePathEntity,Integer> {
}
