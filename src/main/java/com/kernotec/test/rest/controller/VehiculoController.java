package com.kernotec.test.rest.controller;

import com.kernotec.test.jpa.entity.Vehiculo;
import com.kernotec.test.jpa.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<List<Vehiculo>> index(){
        return new ResponseEntity<>(this.vehiculoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> show(@PathVariable UUID id){
        return new ResponseEntity<>(this.vehiculoService.getOne(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehiculo> create(@RequestBody Vehiculo vehiculo){
        return new ResponseEntity<>(this.vehiculoService.guardar(vehiculo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> update(@RequestBody Vehiculo vehiculo, @PathVariable UUID id){
        return new ResponseEntity<>(this.vehiculoService.editar(vehiculo, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vehiculo> destroy(@PathVariable UUID id){
        return new ResponseEntity<>(this.vehiculoService.eliminar(id), HttpStatus.OK);
    }
}
