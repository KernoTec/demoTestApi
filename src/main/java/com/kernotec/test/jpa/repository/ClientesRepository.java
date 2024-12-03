package com.kernotec.test.jpa.repository;

import com.kernotec.test.jpa.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, UUID>  {
}
