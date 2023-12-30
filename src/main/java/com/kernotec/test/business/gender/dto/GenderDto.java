package com.kernotec.test.business.gender.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenderDto {

    private String code;

    private String name;

    public GenderDto(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
