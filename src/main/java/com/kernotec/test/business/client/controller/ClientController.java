package com.kernotec.test.business.client.controller;

import com.kernotec.test.business.client.dto.ClientDto;
import com.kernotec.test.business.client.entity.Client;
import com.kernotec.test.business.client.mapper.ClientMapper;
import com.kernotec.test.business.client.service.ClientService;
import com.kernotec.test.crud.CrudController;
import com.kernotec.test.exception.CrudException;
import com.kernotec.test.exception.CrudExceptionRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController implements CrudController<ClientDto> {

    @Autowired
    private ClientService service;

    @Autowired
    private ClientMapper mapper;

    @Override
    public ClientDto create(ClientDto dto) {
        return null;
    }

    @Override
    public void update(ClientDto dto) {

    }

    @Override
    public void delete(String unique) {

    }

    @Override
    public ClientDto read(String unique) {
        return null;
    }

    @Override
    public List<ClientDto> findAll() {
        try {
            List<ClientDto> dtoList = new ArrayList<ClientDto>();
            for (Client entity : service.findAll()) {
                dtoList.add(mapper.toDto(entity));
            }
            return dtoList;

        } catch (CrudException e) {
            throw new CrudExceptionRest();
        }
    }
}
