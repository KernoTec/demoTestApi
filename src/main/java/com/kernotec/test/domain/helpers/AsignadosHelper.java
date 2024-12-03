package com.kernotec.test.domain.helpers;

import com.kernotec.test.domain.dtos.request.AsignadosRequestDTO;
import com.kernotec.test.jpa.entity.Asignados;

public class AsignadosHelper {
    public static Asignados toEntity(AsignadosRequestDTO dto) {
        Asignados entity = new Asignados();
        entity.setClienteId(dto.getClienteId());
        entity.setVehiculoId(dto.getVehiculoId());
        entity.setFechaAsignacion(dto.getFechaAsignacion());
        return entity;
    }
}
