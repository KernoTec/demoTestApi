package com.kernotec.test.rest.controller;

import com.kernotec.test.jpa.entity.Cliente;
import com.kernotec.test.jpa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    List<Cliente> listar(){

        return service.getAll();

    }

    @GetMapping("/{id}")
    Cliente findByNumDoc(@PathVariable int id){

        return service.findByDocId(id);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Cliente addCliente(@RequestBody Cliente cliente){
        return service.addCliente(cliente);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable UUID id) {
        return service.updateCliente(cliente,id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable UUID id){
        service.deleteCliente(id);
    }
}
