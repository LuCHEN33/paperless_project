package com.paperless.tesseract.persistence.repositories;

import com.paperless.tesseract.persistence.entities.AuthGroupPermissionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthGroupPermissionsRepository extends JpaRepository<AuthGroupPermissionsEntity,Integer> {

}
