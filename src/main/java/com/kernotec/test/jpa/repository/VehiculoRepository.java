package com.kernotec.test.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kernotec.test.jpa.entity.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>  {
}

