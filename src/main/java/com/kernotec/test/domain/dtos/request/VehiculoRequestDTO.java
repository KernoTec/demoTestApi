package com.kernotec.test.domain.dtos.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
public class VehiculoRequestDTO {
    private String marca;
    private String modelo;
    private Integer ano;
    private String placa;
}
