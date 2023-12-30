package com.kernotec.test.business.gender.mapper;

import com.kernotec.test.business.gender.dto.GenderDto;
import com.kernotec.test.business.gender.entity.Gender;
import com.kernotec.test.business.gender.service.GenderService;
import com.kernotec.test.mapper.IMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderMapper implements IMapper<Gender, GenderDto> {

    @Autowired
    private GenderService service;

    @Override
    public GenderDto toDto(Gender entity) {
        return new GenderDto(entity.getCode(), entity.getName());
    }

    @Override
    public Gender toEntity(GenderDto dto, boolean isNew) {
        String code = dto.getCode();
        String name = dto.getName();

        return (isNew) ? new Gender(code, name) : service.findByCode(code);
    }
}
