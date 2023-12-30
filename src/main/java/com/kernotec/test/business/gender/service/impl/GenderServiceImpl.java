package com.kernotec.test.business.gender.service.impl;

import com.kernotec.test.business.gender.entity.Gender;
import com.kernotec.test.business.gender.repository.GenderRepository;
import com.kernotec.test.business.gender.service.GenderService;
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
public class GenderServiceImpl implements GenderService {

    private Logger log = LogManager.getLogger(getClass());

    @Autowired
    private GenderRepository repository;

    @Override
    public Gender create(Gender entity) {
        return null;
    }

    @Override
    public Gender update(Gender entity) {
        return null;
    }

    @Override
    public void delete(UUID key) {

    }

    @Override
    public Gender read(UUID key) {
        return null;
    }

    @Override
    public List<Gender> findAll() {
        return null;
    }

    @Override
    public Gender findByCode(String code) {
        log.info(code);

        try {
            Gender entity = repository.findByCode(code)
                    .orElseThrow(() -> new EntityNotFoundException(EntityNotFoundException.GENDER));

            return entity;
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            throw new CrudException(CrudException.DATA_ACCESS);
        }
    }
}
