package com.paperless.tesseract.persistence.repositories;

import com.paperless.tesseract.persistence.entities.AuthUserGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthGroupRepository extends JpaRepository<AuthUserGroupEntity, Integer> {
}
