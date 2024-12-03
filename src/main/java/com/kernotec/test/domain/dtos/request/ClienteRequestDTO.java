package com.kernotec.test.domain.dtos.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Data
@Getter
@Setter
public class ClienteRequestDTO {
    private String nombre;
    private String paterno;
    private String materno;
    private String tipoDocumento;
    private String numeroDocumento;
    private LocalDateTime fechaNacimiento;
    private String genero;
}
