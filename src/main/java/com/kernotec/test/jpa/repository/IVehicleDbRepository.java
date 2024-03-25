package com.kernotec.test.jpa.repository;

import com.kernotec.test.jpa.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;
import java.util.List;

public interface IVehicleDbRepository extends JpaRepository<Vehicle, UUID> {
    @Query("SELECT v FROM vehicle v WHERE v.client.clientId = :clientId")
    List<Vehicle> findByClientId(UUID clientId);
}
