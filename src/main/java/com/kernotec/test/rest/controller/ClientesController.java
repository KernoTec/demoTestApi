package com.kernotec.test.rest.controller;

import com.kernotec.test.domain.dtos.DefaultResponseDTO;
import com.kernotec.test.domain.dtos.request.ClienteRequestDTO;
import com.kernotec.test.jpa.entity.Clientes;
import com.kernotec.test.jpa.entity.Vehiculos;
import com.kernotec.test.jpa.service.ClientesService;
import com.kernotec.test.jpa.service.interfaces.IClientesService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin
@RestController
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RequestMapping("/api/clientes")
public class ClientesController {

    private final IClientesService clientesService;

    @PostMapping
    public ResponseEntity<DefaultResponseDTO<Clientes>> save(@RequestBody ClienteRequestDTO dto) {
        return ResponseEntity.ok(clientesService.save(dto));
    }

    @GetMapping
    public ResponseEntity<DefaultResponseDTO<List<Clientes>>> getAll() {
        return ResponseEntity.ok(clientesService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponseDTO<Clientes>> update(@PathVariable UUID id, @RequestBody ClienteRequestDTO dto) {
        return ResponseEntity.ok(clientesService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponseDTO<Clientes>> delete(@PathVariable UUID id) {
        return ResponseEntity.ok(clientesService.delete(id));
    }
}
