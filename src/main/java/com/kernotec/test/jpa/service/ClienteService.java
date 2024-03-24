package com.kernotec.test.jpa.service;

import com.kernotec.test.jpa.entity.Cliente;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteService {
    List<Cliente> getAllClientes();
    Optional<Cliente> getClienteById(UUID id);
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(UUID id, Cliente clienteDetails);
    void deleteCliente(UUID id);
}
