package com.kernotec.test.business.client.service.impl;

import com.kernotec.test.business.client.entity.Client;
import com.kernotec.test.business.client.repository.ClientRepository;
import com.kernotec.test.business.client.service.ClientService;
import com.kernotec.test.exception.CrudException;
import com.kernotec.test.exception.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private Logger log = LogManager.getLogger(getClass());

    @Autowired
    private ClientRepository repository;

    @Override
    public Client create(Client entity) {
        Client client = new Client();
        try{
            client = repository.save(entity);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
        }

        return client;
    }

    @Override
    public Client update(Client entity) {
        log.info(entity.getId());
        Client client = new Client();
        try {
            if (!repository.existsById(entity.getId().node())) {
                throw new EntityNotFoundException(EntityNotFoundException.CLIENT);
            }
            client = repository.save(entity);
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
        }

        return client;
    }

    @Override
    public void delete(UUID key) {
        try {
            Optional<Client> entity= repository.findById(key.node());
            if (!entity.isPresent()) {
                throw new EntityNotFoundException(EntityNotFoundException.ENTITY_NOT_FOUND_ERROR);
            }
            Client client = entity.get();
            client.setStatus(0);
            repository.save(client);

        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            throw new CrudException(CrudException.DATA_ACCESS);
        }
    }

    @Override
    public Client read(UUID key) {
        log.info(key.toString());
        try {
            Optional<Client> entity= repository.findById(key.node());
            if (!entity.isPresent()) {
                throw new EntityNotFoundException(EntityNotFoundException.ENTITY_NOT_FOUND_ERROR);
            }
            return entity.get();

        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            throw new CrudException(CrudException.DATA_ACCESS);
        }
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
