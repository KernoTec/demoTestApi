package com.kernotec.test.jpa.service;

import com.kernotec.test.jpa.entity.Client;
import com.kernotec.test.jpa.entity.Vehicle;
import com.kernotec.test.jpa.repository.IClientDbRepository;
import com.kernotec.test.jpa.repository.IVehicleDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleDbService {
    @Autowired
    private IVehicleDbRepository vehicleRepository;
    public Vehicle createVechicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
    public Vehicle getVehicleById(UUID id) { Optional<Vehicle> vehicle = vehicleRepository.findById(id); if (vehicle.isPresent()){return vehicle.get();} throw  new RuntimeException("Client is not found with id :" + id);}
    public Vehicle modifyVehicle(Vehicle vehicle) {return vehicleRepository.save(vehicle);}
    public void removeVehicle(UUID id) { vehicleRepository.deleteById(id);}
    public List<Vehicle> getVehiclesByClientId(UUID id) {return vehicleRepository.findByClientId(id);}
}
