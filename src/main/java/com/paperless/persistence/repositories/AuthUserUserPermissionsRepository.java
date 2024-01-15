package com.paperless.persistence.repositories;

import at.fhtw.swkom.paperless.persistance.entities.AuthUserUserPermissionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserUserPermissionsRepository extends JpaRepository<AuthUserUserPermissionsEntity,Integer> {
}
