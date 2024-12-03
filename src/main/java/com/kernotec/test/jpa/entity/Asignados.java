package com.kernotec.test.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "asignados")
public class Asignados {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, columnDefinition = "uuid DEFAULT uuid_generate_v4()")
    private UUID id;

    @Column(name = "cliente_id")
    private UUID clienteId;


    @Column(name = "vehiculo_id")
    private UUID vehiculoId;

    @Column(name = "fecha_asignacion")
    private LocalDateTime fechaAsignacion;
}
