package com.paperless.persistence.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsSavedViewFilterRuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsSavedViewFilterRuleRepository extends JpaRepository<DocumentsSavedViewFilterRuleEntity,Integer> {
}
