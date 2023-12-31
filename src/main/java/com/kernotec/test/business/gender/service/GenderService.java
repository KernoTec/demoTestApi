package com.kernotec.test.business.gender.service;

import com.kernotec.test.business.gender.entity.Gender;
import com.kernotec.test.crud.CrudService;

import java.util.UUID;

public interface GenderService extends CrudService<Gender, UUID> {

    Gender findByCode(String code);
}
