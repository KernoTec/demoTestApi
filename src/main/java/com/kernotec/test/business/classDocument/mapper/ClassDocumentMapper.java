package com.kernotec.test.business.classDocument.mapper;

import com.kernotec.test.business.classDocument.dto.ClassDocumentDto;
import com.kernotec.test.business.classDocument.entity.ClassDocument;
import com.kernotec.test.business.classDocument.service.ClassDocumentService;
import com.kernotec.test.mapper.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassDocumentMapper implements IMapper<ClassDocument, ClassDocumentDto> {

    @Autowired
    private ClassDocumentService service;

    @Override
    public ClassDocumentDto toDto(ClassDocument entity) {
        return new ClassDocumentDto(entity.getCode(), entity.getName());
    }

    @Override
    public ClassDocument toEntity(ClassDocumentDto dto, boolean isNew) {
        String code = dto.getCode();
        String name = dto.getName();
        return  (isNew) ? new ClassDocument(code, name) : service.findByCode(code);
    }
}
