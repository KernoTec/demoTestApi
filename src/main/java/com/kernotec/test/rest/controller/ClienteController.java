package com.kernotec.test.rest.controller;

import com.kernotec.test.jpa.entity.Cliente;
import com.kernotec.test.jpa.entity.TestDb;
import com.kernotec.test.jpa.service.ClienteService;
import com.kernotec.test.jpa.service.TestDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> index(){
        return new ResponseEntity<>(this.clienteService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> show(@PathVariable UUID id){
        return new ResponseEntity<>(this.clienteService.getOne(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        return new ResponseEntity<>(this.clienteService.guardar(cliente), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable UUID id){
        return new ResponseEntity<>(this.clienteService.editar(cliente, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> destroy(@PathVariable UUID id){
        return new ResponseEntity<>(this.clienteService.eliminar(id), HttpStatus.OK);
    }
}
