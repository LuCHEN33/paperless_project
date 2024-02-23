package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.DocumentsDocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DocumentsDocumentRepository extends JpaRepository<DocumentsDocumentEntity,Integer> {
    @Modifying
    @Transactional
    @Query("update Services_Document d set d.content = ?1 where d.id = ?2")
    void updateContent(String content, long id);

    @Query("select d.title from Services_Document d where d.id = ?1")
    String findTitleById(long id);
}
