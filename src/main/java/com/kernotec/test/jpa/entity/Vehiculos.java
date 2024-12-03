package com.kernotec.test.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculos {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, columnDefinition = "uuid DEFAULT uuid_generate_v4()")
    private UUID id;

    @Column(length = 100)
    private String marca;

    @Column(length = 100)
    private String modelo;

    private Integer ano;

    @Column(length = 100, unique = true)
    private String placa;

    private Boolean asignado;

    private Boolean deleted;
}
