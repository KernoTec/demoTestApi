package com.kernotec.test.jpa.service;

import com.kernotec.test.jpa.entity.Cliente;
import com.kernotec.test.jpa.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;


    // Crear cliente
    public void createCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    // Listar clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }


    // Actualizar clientes
    public Cliente updateCliente(Long id, Cliente clienteActualizado) {
    Cliente clienteExistente = clienteRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + id));

    // Actualizar los campos del cliente existente con los valores proporcionados
    clienteExistente.setNombre(clienteActualizado.getNombre());
    clienteExistente.setPaterno(clienteActualizado.getPaterno());
    clienteExistente.setMaterno(clienteActualizado.getMaterno());
    clienteExistente.setTipoDocumento(clienteActualizado.getTipoDocumento());
    clienteExistente.setNumeroDocumento(clienteActualizado.getNumeroDocumento());
    clienteExistente.setFechaNacimiento(clienteActualizado.getFechaNacimiento());
    clienteExistente.setGenero(clienteActualizado.getGenero());

    return clienteRepository.save(clienteExistente);
}

    //Borrar cliente
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }



}
