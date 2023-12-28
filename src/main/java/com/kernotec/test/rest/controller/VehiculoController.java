package com.kernotec.test.rest.controller;

import com.kernotec.test.jpa.entity.Cliente;
import com.kernotec.test.jpa.entity.Vehiculo;
import com.kernotec.test.jpa.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService service;

    @GetMapping
    List<Vehiculo> listar(){
        return service.getAll();
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public Vehiculo addVehiculo(@RequestBody Vehiculo vehiculo){
        return service.addVehiculo(vehiculo);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    Vehiculo updateVehiculo(@RequestBody Vehiculo vehiculo, @PathVariable UUID id) {
        return service.updateVehiculo(vehiculo,id);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteVehiculo(@PathVariable UUID id){
        service.deleteVehiculo(id);
    }
}
