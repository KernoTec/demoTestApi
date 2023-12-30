package com.kernotec.test.business.client.dto;

import com.kernotec.test.business.classDocument.entity.ClassDocument;
import com.kernotec.test.business.gender.entity.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClientDto {

    private String name;

    private String surname1;

    private String surname2;

    private ClassDocument classDocumentId;

    private Integer numberDocument;

    private LocalDate birthday;

    private Gender genderId;

    public ClientDto(String name, String surname1, String surname2, ClassDocument classDocumentId, Integer numberDocument, LocalDate birthday, Gender genderId) {
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.classDocumentId = classDocumentId;
        this.numberDocument = numberDocument;
        this.birthday = birthday;
        this.genderId = genderId;
    }
}
