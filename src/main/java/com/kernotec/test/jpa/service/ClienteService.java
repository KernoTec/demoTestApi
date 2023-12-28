package com.kernotec.test.jpa.service;

import com.kernotec.test.jpa.entity.Cliente;
import com.kernotec.test.jpa.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll(){
        List<Cliente> clientes = (List<Cliente>) this.clienteRepository.findAll();
        return clientes;
    }

    public Cliente getOne(UUID id) {
        Cliente cliente = this.clienteRepository.findById(id).orElse(null);
        return cliente;
    }

    public Cliente guardar(Cliente cliente) {
        Cliente clienteNew = this.clienteRepository.save(cliente);
        return clienteNew;
    }

    public Cliente editar(Cliente cliente, UUID id) {
        Cliente clienteDB = this.clienteRepository.findById(id).orElse(null);

        clienteDB.setNombre(cliente.getNombre());
        clienteDB.setPaterno(cliente.getPaterno());
        clienteDB.setMaterno(cliente.getMaterno());
        clienteDB.setTipoDocumento(cliente.getTipoDocumento());
        clienteDB.setNumeroDocumento(cliente.getNumeroDocumento());
        clienteDB.setFechaNacimiento(cliente.getFechaNacimiento());
        clienteDB.setGenero(cliente.getGenero());

        Cliente clienteUpdated = this.clienteRepository.save(clienteDB);
        return clienteUpdated;
    }

    public Cliente eliminar(UUID id) {
        Cliente cliente = this.clienteRepository.findById(id).orElse(null);
        this.clienteRepository.delete(cliente);
        return cliente;
    }

}
