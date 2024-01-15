package com.paperless.persistence.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsUISettingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsUISettingsRepository extends JpaRepository<DocumentsUISettingsEntity,Integer> {
}
