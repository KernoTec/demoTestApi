package com.kernotec.test.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "paterno", length = 100)
    private String paterno;

    @Column(name = "materno", length = 100)
    private String materno;

    @Column(name = "tipo_documento", length = 50)
    private String tipoDocumento;

    @Column(name = "numero_documento", length = 20, unique = true)
    private String numeroDocumento;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "genero", length = 10)
    private String genero;
}
