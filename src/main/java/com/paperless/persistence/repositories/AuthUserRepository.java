package com.paperless.persistence.repositories;

import at.fhtw.swkom.paperless.persistance.entities.AuthUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUserEntity,Integer> {
}
