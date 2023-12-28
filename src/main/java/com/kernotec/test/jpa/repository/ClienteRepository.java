package com.kernotec.test.jpa.repository;

import com.kernotec.test.jpa.entity.Cliente;
import com.kernotec.test.jpa.entity.TestDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    @Query("select u from Cliente u where u.numeroDocumento = ?1")
    Cliente findByNumDoc(int numdoc);
}
