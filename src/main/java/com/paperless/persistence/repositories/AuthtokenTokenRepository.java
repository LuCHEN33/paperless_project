package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.AuthtokenTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthtokenTokenRepository extends JpaRepository<AuthtokenTokenEntity,Long> {
}
