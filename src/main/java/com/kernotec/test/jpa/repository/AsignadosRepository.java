package com.kernotec.test.jpa.repository;

import com.kernotec.test.jpa.entity.Asignados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AsignadosRepository extends JpaRepository<Asignados, UUID> {
    List<Asignados> findAllByClienteId(UUID id);
}
