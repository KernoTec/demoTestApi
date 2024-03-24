package com.kernotec.test.jpa.service.Impl;

import com.kernotec.test.jpa.entity.Cliente;
import com.kernotec.test.jpa.repository.ClienteRepository;
import com.kernotec.test.jpa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAllClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getClienteById(UUID id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(UUID id, Cliente clienteDetails) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.setNombre(clienteDetails.getNombre());
            cliente.setPaterno(clienteDetails.getPaterno());
            cliente.setMaterno(clienteDetails.getMaterno());
            cliente.setTipoDocumento(clienteDetails.getTipoDocumento());
            cliente.setNumeroDocumento(clienteDetails.getNumeroDocumento());
            cliente.setFechaNacimiento(clienteDetails.getFechaNacimiento());
            cliente.setGenero(clienteDetails.getGenero());
            return clienteRepository.save(cliente);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCliente(UUID id) {
        clienteRepository.deleteById(id);
    }
}
