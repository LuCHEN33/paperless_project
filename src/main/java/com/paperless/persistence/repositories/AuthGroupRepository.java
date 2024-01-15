package com.paperless.persistence.repositories;

import at.fhtw.swkom.paperless.persistance.entities.AuthUserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthGroupRepository extends JpaRepository<AuthUserGroupEntity, Integer> {
}
