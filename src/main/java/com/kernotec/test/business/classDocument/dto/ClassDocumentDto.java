package com.kernotec.test.business.classDocument.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassDocumentDto {

    private String code;

    private String name;

    public ClassDocumentDto(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
