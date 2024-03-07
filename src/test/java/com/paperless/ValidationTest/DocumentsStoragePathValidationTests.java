package com.paperless.ValidationTest;

import com.paperless.persistence.entities.DocumentsStoragePathEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Slf4j
class DocumentsStoragePathValidationTests {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Test
    @DisplayName("Validate with valid entity data")
    void allValid() {
        // Arrange
        DocumentsStoragePathEntity entity = new DocumentsStoragePathEntity();
        entity.setName("Name");
        entity.setMatch("Match");
        entity.setMatchingAlgorithm(1);
        entity.setIsInsensitive(true);
        entity.setPath("/valid/path");

        // Act
        Set violations = validator.validate(entity);

        // Assert
        assert violations.isEmpty() : "Expected no validation errors";
    }

    @Test
    @DisplayName("Validate with invalid name")
    void nameInvalid() {
        // Arrange
        DocumentsStoragePathEntity entity = new DocumentsStoragePathEntity();
        entity.setName(""); // Invalid name
        entity.setMatch("Match");
        entity.setMatchingAlgorithm(1);
        entity.setIsInsensitive(true);
        entity.setPath("/valid/path");

        // Act
        Set violations = validator.validate(entity);

        // Log errors
        violations.forEach(violation -> log.error(violation.toString()));

        // Assert
        assert !violations.isEmpty() : "Expected validation errors for name";
    }

    @Test
    @DisplayName("Validate with invalid match")
    void matchInvalid() {
        // Arrange
        DocumentsStoragePathEntity entity = new DocumentsStoragePathEntity();
        entity.setName("Name");
        entity.setMatch(""); // Invalid match
        entity.setMatchingAlgorithm(1);
        entity.setIsInsensitive(true);
        entity.setPath("/valid/path");

        // Act
        Set violations = validator.validate(entity);

        // Log errors
        violations.forEach(violation -> log.error(violation.toString()));

        // Assert
        assert !violations.isEmpty() : "Expected validation errors for match";
    }

    @Test
    @DisplayName("Validate with invalid path")
    void pathInvalid() {
        // Arrange
        DocumentsStoragePathEntity entity = new DocumentsStoragePathEntity();
        entity.setName("Name");
        entity.setMatch("Match");
        entity.setMatchingAlgorithm(1);
        entity.setIsInsensitive(true);
        entity.setPath(""); // Invalid path

        // Act
        Set violations = validator.validate(entity);

        // Log errors
        violations.forEach(violation -> log.error(violation.toString()));

        // Assert
        assert !violations.isEmpty() : "Expected validation errors for path";
    }
}


