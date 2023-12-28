package com.kernotec.test.jpa.service;

import com.kernotec.test.jpa.entity.Vehiculo;
import com.kernotec.test.jpa.repository.VehiculoRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    // Crear vehículo
    public void createVehiculo(Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
    }

    // Listar vehículos
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoRepository.findAll();
    }

    // Actualizar vehículo
    public Vehiculo updateVehiculo(Long id, Vehiculo vehiculoActualizado) {
        Vehiculo vehiculoExistente = vehiculoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehículo no encontrado con ID: " + id));

        // Actualizar los campos del vehículo existente con los valores proporcionados
        vehiculoExistente.setMarca(vehiculoActualizado.getMarca());
        vehiculoExistente.setModelo(vehiculoActualizado.getModelo());
        vehiculoExistente.setAno(vehiculoActualizado.getAno());
        vehiculoExistente.setPlaca(vehiculoActualizado.getPlaca());

        return vehiculoRepository.save(vehiculoExistente);
    }

    // Borrar vehículo
    public void deleteVehiculo(Long id) {
        vehiculoRepository.deleteById(id);
    }
}
