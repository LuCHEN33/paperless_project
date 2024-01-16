package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.PaperlessMailProcessedmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperlessMailProcessedmailRepository extends JpaRepository<PaperlessMailProcessedmailEntity,Integer> {
}
