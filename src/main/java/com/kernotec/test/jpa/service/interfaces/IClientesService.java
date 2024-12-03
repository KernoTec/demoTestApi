package com.kernotec.test.jpa.service.interfaces;

import com.kernotec.test.domain.dtos.DefaultResponseDTO;
import com.kernotec.test.domain.dtos.request.ClienteRequestDTO;
import com.kernotec.test.jpa.entity.Clientes;

import java.util.List;
import java.util.UUID;

public interface IClientesService {
    DefaultResponseDTO<Clientes> save(ClienteRequestDTO clientes);
    DefaultResponseDTO<List<Clientes>> getAll();
    DefaultResponseDTO<Clientes> update(UUID id, ClienteRequestDTO dto);
    DefaultResponseDTO<Clientes> delete(UUID id);
}
