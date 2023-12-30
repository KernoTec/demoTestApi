package com.kernotec.test.business.classDocument.service.impl;

import com.kernotec.test.business.classDocument.entity.ClassDocument;
import com.kernotec.test.business.classDocument.repository.ClassDocumentRepository;
import com.kernotec.test.business.classDocument.service.ClassDocumentService;
import com.kernotec.test.exception.CrudException;
import com.kernotec.test.exception.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClassDocumentServiceImpl implements ClassDocumentService {

    private Logger log = LogManager.getLogger(getClass());

    @Autowired
    private ClassDocumentRepository repository;

    @Override
    public ClassDocument create(ClassDocument entity) {
        return null;
    }

    @Override
    public ClassDocument update(ClassDocument entity) {
        return null;
    }

    @Override
    public void delete(UUID key) {

    }

    @Override
    public ClassDocument read(UUID key) {
        return null;
    }

    @Override
    public List<ClassDocument> findAll() {
        return null;
    }


    @Override
    public ClassDocument findByCode(String code) {
        log.info(code);

        try {
            ClassDocument entity = repository.findByCode(code)
                    .orElseThrow(() -> new EntityNotFoundException(EntityNotFoundException.CLASS_DOCUMENT));

            return entity;
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            throw new CrudException(CrudException.DATA_ACCESS);
        }
    }
}
