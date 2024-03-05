package com.paperless.tesseract.persistence.repositories;

import com.paperless.tesseract.persistence.entities.AuthPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthPermissionRepository extends JpaRepository<AuthPermissionEntity,Integer> {
}
