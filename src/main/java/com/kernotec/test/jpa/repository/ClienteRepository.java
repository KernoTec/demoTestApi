package com.kernotec.test.jpa.repository;

import com.kernotec.test.jpa.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>  {
}
