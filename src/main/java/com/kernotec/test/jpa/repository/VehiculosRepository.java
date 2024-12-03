package com.kernotec.test.jpa.repository;

import com.kernotec.test.jpa.entity.Vehiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehiculosRepository extends JpaRepository<Vehiculos, UUID> {
}
