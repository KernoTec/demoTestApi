package com.kernotec.test.business.client.service.impl;

import com.kernotec.test.business.client.entity.Client;
import com.kernotec.test.business.client.repository.ClientRepository;
import com.kernotec.test.business.client.service.ClientService;
import com.kernotec.test.exception.CrudException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class clientServiceImpl implements ClientService {

    private Logger log = LogManager.getLogger(getClass());

    @Autowired
    private ClientRepository repository;

    @Override
    public Client create(Client entity) {
        return null;
    }

    @Override
    public Client update(Client entity) {
        return null;
    }

    @Override
    public void delete(UUID key) {

    }

    @Override
    public Client read(UUID key) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        try {
            return repository.findAll();
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            throw new CrudException(CrudException.DATA_ACCESS);
        }
    }
}
