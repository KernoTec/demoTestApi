package com.kernotec.test.rest.controller;

import com.kernotec.test.jpa.entity.Vehiculo;
import com.kernotec.test.jpa.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping("/create")
    public void createVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculoService.createVehiculo(vehiculo);
    }

    @GetMapping("/show")
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoService.getAllVehiculos();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable Long id, @RequestBody Vehiculo vehiculo) {
        try {
            Vehiculo vehiculoModificado = vehiculoService.updateVehiculo(id, vehiculo);
            return new ResponseEntity<>(vehiculoModificado, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVehiculo(@PathVariable Long id) {
        try {
            vehiculoService.deleteVehiculo(id);
            return new ResponseEntity<>("Vehículo eliminado correctamente", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Vehículo no encontrado con ID: " + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el vehículo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
