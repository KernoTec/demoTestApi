package com.kernotec.test.jpa.repository;

import com.kernotec.test.jpa.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IClientDbRepository extends JpaRepository<Client, UUID>  {
}
