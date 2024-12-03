package com.kernotec.test.domain.dtos.request;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@Getter
@Setter
public class AsignadosRequestDTO {
    private UUID clienteId;
    private UUID vehiculoId;
    private LocalDateTime fechaAsignacion;
}
