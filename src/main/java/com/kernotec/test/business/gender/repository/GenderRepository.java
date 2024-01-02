package com.kernotec.test.business.gender.repository;

import com.kernotec.test.business.gender.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GenderRepository extends JpaRepository<Gender, UUID> {

    Optional<Gender> findByCode(String code);
}
