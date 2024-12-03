package com.kernotec.test.rest.controller;

import com.kernotec.test.domain.dtos.DefaultResponseDTO;
import com.kernotec.test.domain.dtos.request.AsignadosRequestDTO;
import com.kernotec.test.domain.dtos.request.ClienteRequestDTO;
import com.kernotec.test.domain.dtos.request.VehiculoRequestDTO;
import com.kernotec.test.jpa.entity.Asignados;
import com.kernotec.test.jpa.entity.Clientes;
import com.kernotec.test.jpa.entity.Vehiculos;
import com.kernotec.test.jpa.service.AsignadosService;
import com.kernotec.test.jpa.service.interfaces.IAsignadosService;
import com.kernotec.test.jpa.service.interfaces.IVehiculosService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@CrossOrigin
@RestController
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RequestMapping("/api/asignados")
public class AsignadosController {
    private final IAsignadosService asignadosService;

    @PostMapping
    public ResponseEntity<DefaultResponseDTO<Asignados>> save(@RequestBody AsignadosRequestDTO dto) {
        return ResponseEntity.ok(asignadosService.save(dto));
    }

}
