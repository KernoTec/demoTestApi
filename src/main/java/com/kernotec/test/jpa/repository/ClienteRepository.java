package com.kernotec.test.jpa.repository;

import com.kernotec.test.jpa.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, UUID> {

}