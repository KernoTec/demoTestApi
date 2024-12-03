package com.kernotec.test.domain.helpers;

import com.kernotec.test.domain.dtos.request.ClienteRequestDTO;
import com.kernotec.test.jpa.entity.Clientes;
import org.springframework.stereotype.Service;

@Service
public class ClientesHelper {
    public static Clientes toEntity(ClienteRequestDTO dto) {
        Clientes entity = new Clientes();
        entity.setNombre(dto.getNombre());
        entity.setPaterno(dto.getPaterno());
        entity.setMaterno(dto.getMaterno());
        entity.setTipoDocumento(dto.getTipoDocumento());
        entity.setNumeroDocumento(dto.getNumeroDocumento());
        entity.setGenero(dto.getGenero());
        entity.setFechaNacimiento(dto.getFechaNacimiento());
        entity.setDeleted(Boolean.FALSE);
        return entity;
    }
}
