package com.kernotec.test.jpa.repository;

import com.kernotec.test.jpa.entity.TestDb;
import com.kernotec.test.jpa.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, UUID> {
}
