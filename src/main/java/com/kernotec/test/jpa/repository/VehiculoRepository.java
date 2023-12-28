package com.kernotec.test.jpa.repository;

import com.kernotec.test.jpa.entity.Vehiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, UUID> {

}
