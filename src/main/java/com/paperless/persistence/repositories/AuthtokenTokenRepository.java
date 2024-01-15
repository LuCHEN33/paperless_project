package com.paperless.persistence.repositories;

import at.fhtw.swkom.paperless.persistance.entities.AuthtokenTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthtokenTokenRepository extends JpaRepository<AuthtokenTokenEntity,Integer> {
}
