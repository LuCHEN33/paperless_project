package com.paperless.persistence.repositories;

import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailruleAssignTagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperlessMailMailruleAssignTagsRepository extends JpaRepository<PaperlessMailMailruleAssignTagsEntity,Integer> {
}
