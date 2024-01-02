package com.kernotec.test.business.classDocument.service;

import com.kernotec.test.business.classDocument.entity.ClassDocument;
import com.kernotec.test.crud.CrudService;

import java.util.UUID;

public interface ClassDocumentService extends CrudService<ClassDocument, UUID> {

    ClassDocument findByCode(String code);
}
