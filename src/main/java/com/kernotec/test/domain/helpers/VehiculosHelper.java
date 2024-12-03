package com.kernotec.test.domain.helpers;

import com.kernotec.test.domain.dtos.request.VehiculoRequestDTO;
import com.kernotec.test.jpa.entity.Vehiculos;
import org.springframework.stereotype.Service;

@Service
public class VehiculosHelper {
    public static Vehiculos toEntity(VehiculoRequestDTO dto) {
        Vehiculos entity = new Vehiculos();
        entity.setModelo(dto.getMarca());
        entity.setMarca(dto.getModelo());
        entity.setAno(dto.getAno());
        entity.setPlaca(dto.getPlaca());
        entity.setAsignado(Boolean.FALSE);
        entity.setDeleted(Boolean.FALSE);
        return entity;
    }
}
