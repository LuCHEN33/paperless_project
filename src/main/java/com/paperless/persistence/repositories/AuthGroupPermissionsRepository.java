package com.paperless.persistence.repositories;

import at.fhtw.swkom.paperless.persistance.entities.AuthGroupPermissionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthGroupPermissionsRepository extends JpaRepository<AuthGroupPermissionsEntity,Integer> {

}
