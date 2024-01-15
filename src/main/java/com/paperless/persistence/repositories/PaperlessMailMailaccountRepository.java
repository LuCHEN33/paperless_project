package com.paperless.persistence.repositories;

import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailMailaccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperlessMailMailaccountRepository extends JpaRepository<PaperlessMailMailaccountEntity,Integer> {
}
