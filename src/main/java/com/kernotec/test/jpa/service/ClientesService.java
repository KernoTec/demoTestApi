package com.kernotec.test.jpa.service;

import com.kernotec.test.domain.dtos.DefaultResponseDTO;
import com.kernotec.test.domain.dtos.request.ClienteRequestDTO;
import com.kernotec.test.domain.exceptions.EntityNotFoundException;
import com.kernotec.test.domain.helpers.ClientesHelper;
import com.kernotec.test.jpa.entity.Clientes;
import com.kernotec.test.jpa.repository.ClientesRepository;
import com.kernotec.test.jpa.service.interfaces.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientesService implements IClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public DefaultResponseDTO<Clientes> save(ClienteRequestDTO clientes) {
        Clientes clientesCreated = clientesRepository.save(ClientesHelper.toEntity(clientes));
        return DefaultResponseDTO.<Clientes>builder()
                .httpStatus(HttpStatus.CREATED)
                .message("Cliente creado correctamente.")
                .response(clientesCreated)
                .build();
    }

    public DefaultResponseDTO<List<Clientes>> getAll() {
        List<Clientes> clientes = clientesRepository.findAll();
        return DefaultResponseDTO.<List<Clientes>>builder()
                .httpStatus(HttpStatus.OK)
                .message("Clientes obtenidos correctamente.")
                .response(clientes)
                .build();
    }

    public Clientes getById(UUID id) {
        Optional<Clientes> clientes = clientesRepository.findById(id);
        if(clientes.isEmpty()) {
            throw new EntityNotFoundException(Clientes.class.getSimpleName());
        }
        return clientes.get();
    }

    public DefaultResponseDTO<Clientes> update(UUID id, ClienteRequestDTO dto) {
        Clientes clientes = getById(id);
        Clientes clientesActualizado = ClientesHelper.toEntity(dto);
        clientesActualizado.setId(clientes.getId());
        Clientes clientesUpdated = clientesRepository.save(clientesActualizado);
        return DefaultResponseDTO.<Clientes>builder()
                .httpStatus(HttpStatus.OK)
                .message("Clientes Actualizado correctamente.")
                .response(clientesUpdated)
                .build();

    }

    public DefaultResponseDTO<Clientes> delete(UUID id) {
        Clientes clientes = getById(id);
        clientes.setDeleted(Boolean.TRUE);
        Clientes clientesUpdated = clientesRepository.save(clientes);
        return DefaultResponseDTO.<Clientes>builder()
                .httpStatus(HttpStatus.OK)
                .message("Cliente eliminado correctamente.")
                .response(clientesUpdated)
                .build();
    }
}
