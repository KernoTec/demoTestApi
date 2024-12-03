package com.kernotec.test.rest.controller;

import com.kernotec.test.domain.dtos.DefaultResponseDTO;
import com.kernotec.test.domain.dtos.request.VehiculoRequestDTO;
import com.kernotec.test.jpa.entity.Vehiculos;
import com.kernotec.test.jpa.service.interfaces.IVehiculosService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RequestMapping("/api/vehiculos")
public class VehiculosController {

    private final IVehiculosService vehiculosService;

    @PostMapping
    public ResponseEntity<DefaultResponseDTO<Vehiculos>> save(@RequestBody VehiculoRequestDTO dto) {
        return ResponseEntity.ok(vehiculosService.save(dto));
    }

    @GetMapping()
    public ResponseEntity<DefaultResponseDTO<List<Vehiculos>>> getAll() {
        return ResponseEntity.ok(vehiculosService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponseDTO<List<Vehiculos>>> getAllByCostumer(@PathVariable UUID id) {
        return ResponseEntity.ok(vehiculosService.getAllByCostumer(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponseDTO<Vehiculos>> update(@PathVariable UUID id, @RequestBody VehiculoRequestDTO dto) {
        return ResponseEntity.ok(vehiculosService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponseDTO<Vehiculos>> delete(@PathVariable UUID id) {
        return ResponseEntity.ok(vehiculosService.delete(id));
    }

}
