package com.paperless.persistence.repositories;

import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailruleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperlessMailMailruleRepository extends JpaRepository<PaperlessMailMailruleEntity,Integer> {
}
