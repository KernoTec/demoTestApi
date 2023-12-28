package com.kernotec.test.jpa.service;

import com.kernotec.test.jpa.entity.Cliente;
import com.kernotec.test.jpa.entity.Vehiculo;
import com.kernotec.test.jpa.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository repository;

    public List<Vehiculo> getAll() {
        return repository.findAll();
    }

    public Vehiculo addVehiculo(Vehiculo vehiculo){
        return repository.save(vehiculo);
    }

    public Vehiculo updateVehiculo(Vehiculo vehiculo, UUID id){
        return repository.findById(id)
                .map(vehiculo1 -> {
                    vehiculo1.setMarca(vehiculo.getMarca());
                    vehiculo1.setModelo(vehiculo.getModelo());
                    vehiculo1.setPlaca(vehiculo.getPlaca());
                    vehiculo1.setAnio(vehiculo.getAnio());
                    vehiculo1.setCliente(vehiculo.getCliente());
                    return repository.save(vehiculo1);
                }).orElse( null);
    }

    public void deleteVehiculo(UUID id){
        repository.deleteById(id);
    }
}
