package com.kernotec.test.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, columnDefinition = "uuid DEFAULT uuid_generate_v4()")
    private UUID id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "paterno", length = 100)
    private String paterno;

    @Column(name = "materno", length = 100)
    private String materno;

    @Column(name = "tipo_documento", length = 5)
    private String tipoDocumento;

    @Column(name = "numero_documento", length = 50, unique = true)
    private String numeroDocumento;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "genero", length = 1)
    private String genero;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<Vehiculo> vehiculos = new ArrayList<>();

}
