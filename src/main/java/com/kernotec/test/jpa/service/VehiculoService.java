package com.kernotec.test.jpa.service;

import com.kernotec.test.jpa.entity.Vehiculo;
import com.kernotec.test.jpa.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> getAll(){
        List<Vehiculo> vehiculos = (List<Vehiculo>) this.vehiculoRepository.findAll();
        return vehiculos;
    }

    public Vehiculo getOne(UUID id) {
        Vehiculo vehiculo = this.vehiculoRepository.findById(id).orElse(null);
        return vehiculo;
    }

    public Vehiculo guardar(Vehiculo vehiculo) {
        Vehiculo vehiculoNew = this.vehiculoRepository.save(vehiculo);
        return vehiculoNew;
    }

    public Vehiculo editar(Vehiculo vehiculo, UUID id) {
        Vehiculo vehiculoDB = this.vehiculoRepository.findById(id).orElse(null);

        vehiculoDB.setMarca(vehiculo.getMarca());
        vehiculoDB.setModelo(vehiculo.getModelo());
        vehiculoDB.setAnio(vehiculo.getAnio());
        vehiculoDB.setPlaca(vehiculo.getPlaca());
        vehiculoDB.setClienteId(vehiculo.getClienteId());

        Vehiculo vehiculoUpdated = this.vehiculoRepository.save(vehiculoDB);
        return vehiculoUpdated;
    }

    public Vehiculo eliminar(UUID id) {
        Vehiculo vehiculo = this.vehiculoRepository.findById(id).orElse(null);
        this.vehiculoRepository.delete(vehiculo);
        return vehiculo;
    }

}
