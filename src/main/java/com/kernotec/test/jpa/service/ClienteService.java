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
    private ClienteRepository repository;

    public List<Cliente> getAll() {
        return repository.findAll();
    }

    public Cliente findByDocId(int numDoc) {
        return repository.findByNumDoc(numDoc);
    }

    public Cliente addCliente(Cliente cliente){
        return repository.save(cliente);
    }

    public Cliente updateCliente(Cliente cliente, UUID id){
         return repository.findById(id)
                .map(cliente1 -> {
                    cliente1.setNombre(cliente.getNombre());
                    cliente1.setPaterno(cliente.getPaterno());
                    cliente1.setMaterno(cliente.getMaterno());
                    cliente1.setGenero(cliente.getGenero());
                    cliente1.setFechaNacimiento(cliente.getFechaNacimiento());
                    cliente1.setTipoDocumento(cliente.getTipoDocumento());
                    cliente1.setNumeroDocumento(cliente.getNumeroDocumento());
                    return repository.save(cliente);
                }).orElse( null);
    }

    public void deleteCliente(UUID id){
        repository.deleteById(id);
    }
}
