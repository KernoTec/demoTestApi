package com.kernotec.test.jpa.service;

import com.kernotec.test.jpa.entity.Vehiculo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehiculoService {
    List<Vehiculo> getAllVehiculos();
    Optional<Vehiculo> getVehiculoById(UUID id);
    Vehiculo createVehiculo(Vehiculo vehiculo);
    Vehiculo updateVehiculo(UUID id, Vehiculo vehiculoDetails);
    void deleteVehiculo(UUID id);
    List<Vehiculo> getVehiculosByClienteId(UUID clienteId);
}
