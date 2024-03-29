package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.PaperlessMailMailaccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperlessMailMailaccountRepository extends JpaRepository<PaperlessMailMailaccountEntity,Integer> {
}
