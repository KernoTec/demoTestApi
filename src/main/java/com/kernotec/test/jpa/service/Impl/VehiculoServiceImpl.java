package com.kernotec.test.jpa.service.Impl;

import com.kernotec.test.jpa.entity.Vehiculo;
import com.kernotec.test.jpa.repository.VehiculoRepository;
import com.kernotec.test.jpa.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Autowired
    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<Vehiculo> getAllVehiculos() {
        return (List<Vehiculo>) vehiculoRepository.findAll();
    }

    @Override
    public Optional<Vehiculo> getVehiculoById(UUID id) {
        return vehiculoRepository.findById(id);
    }

    @Override
    public Vehiculo createVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public Vehiculo updateVehiculo(UUID id, Vehiculo vehiculoDetails) {
        Optional<Vehiculo> optionalVehiculo = vehiculoRepository.findById(id);
        if (optionalVehiculo.isPresent()) {
            Vehiculo vehiculo = optionalVehiculo.get();
            vehiculo.setMarca(vehiculoDetails.getMarca());
            vehiculo.setModelo(vehiculoDetails.getModelo());
            vehiculo.setAnio(vehiculoDetails.getAnio());
            vehiculo.setPlaca(vehiculoDetails.getPlaca());
            return vehiculoRepository.save(vehiculo);
        } else {
            return null;
        }
    }

    @Override
    public void deleteVehiculo(UUID id) {
        vehiculoRepository.deleteById(id);
    }

    @Override
    public List<Vehiculo> getVehiculosByClienteId(UUID clienteId) {
        return vehiculoRepository.findByClienteId(clienteId);
    }
}
