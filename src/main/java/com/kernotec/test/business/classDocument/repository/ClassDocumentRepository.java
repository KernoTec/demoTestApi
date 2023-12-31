package com.kernotec.test.business.classDocument.repository;

import com.kernotec.test.business.classDocument.entity.ClassDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClassDocumentRepository extends JpaRepository<ClassDocument, UUID> {

    Optional<ClassDocument> findByCode(String code);
}
