package com.kernotec.test.rest.controller;

import com.kernotec.test.jpa.entity.Cliente;
import com.kernotec.test.jpa.entity.Vehiculo;
import com.kernotec.test.jpa.service.ClienteService;
import com.kernotec.test.jpa.service.VehiculoService;
import com.kernotec.test.utils.constants.EndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(EndPoint.VEHICULOS)
@CrossOrigin(origins = EndPoint.ALLOWED_ORIGIN)
public class VehiculoController {

    private final VehiculoService vehiculoService;
    private final ClienteService clienteService;

    @Autowired
    public VehiculoController(VehiculoService vehiculoService, ClienteService clienteService) {
        this.vehiculoService = vehiculoService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Vehiculo>> getAllVehiculos() {
        List<Vehiculo> vehiculos = vehiculoService.getAllVehiculos();
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable("id") UUID id) {
        Optional<Vehiculo> vehiculo = vehiculoService.getVehiculoById(id);
        return vehiculo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/cliente/{clienteId}")
    public ResponseEntity<Vehiculo> createVehiculoByClientId(@PathVariable("clienteId") UUID clienteId, @RequestBody Vehiculo vehiculo) {
        Optional<Cliente> optionalCliente = clienteService.getClienteById(clienteId);
        if (!optionalCliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Cliente cliente = optionalCliente.get();
        vehiculo.setCliente(cliente);
        Vehiculo createdVehiculo = vehiculoService.createVehiculo(vehiculo);
        return ResponseEntity.created(URI.create("/api/vehiculos/cliente" + clienteId + "/" + createdVehiculo.getId()))
                .body(createdVehiculo);
    }

    @PostMapping
    public ResponseEntity<Vehiculo> createVehiculo(@PathVariable("clienteId") UUID clienteId, @RequestBody Vehiculo vehiculo) {
        Vehiculo createdVehiculo = vehiculoService.createVehiculo(vehiculo);
        return new ResponseEntity<>(createdVehiculo, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable("id") UUID id, @RequestBody Vehiculo vehiculo) {
        Vehiculo updatedVehiculo = vehiculoService.updateVehiculo(id, vehiculo);
        if (updatedVehiculo != null) {
            return new ResponseEntity<>(updatedVehiculo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/cliente/{clienteId}/{id}")
    public ResponseEntity<Vehiculo> updateVehiculoByClientId(@PathVariable("clienteId") UUID clienteId, @PathVariable("id") UUID id, @RequestBody Vehiculo vehiculo) {
        Optional<Cliente> optionalCliente = clienteService.getClienteById(clienteId);
        if (!optionalCliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Vehiculo updatedVehiculo = vehiculoService.updateVehiculo(id, vehiculo);

        if (updatedVehiculo != null) {
            return ResponseEntity.ok(updatedVehiculo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehiculo(@PathVariable("id") UUID id) {
        vehiculoService.deleteVehiculo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/cliente/{clienteId}/{id}")
    public ResponseEntity<Void> deleteVehiculoByClientId(@PathVariable("clienteId") UUID clienteId, @PathVariable("id") UUID id) {
        Optional<Cliente> optionalCliente = clienteService.getClienteById(clienteId);
        if (!optionalCliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        vehiculoService.deleteVehiculo(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Vehiculo>> getVehiculosByClienteId(@PathVariable("clienteId") UUID clienteId) {
        List<Vehiculo> vehiculos = vehiculoService.getVehiculosByClienteId(clienteId);
        if (!vehiculos.isEmpty()) {
            return new ResponseEntity<>(vehiculos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
