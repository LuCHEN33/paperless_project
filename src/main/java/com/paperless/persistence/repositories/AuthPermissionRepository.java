package com.paperless.persistence.repositories;

import at.fhtw.swkom.paperless.persistance.entities.AuthPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthPermissionRepository extends JpaRepository<AuthPermissionEntity,Integer> {
}
