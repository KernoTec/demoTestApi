package com.kernotec.test.jpa.service.interfaces;

import com.kernotec.test.domain.dtos.DefaultResponseDTO;
import com.kernotec.test.domain.dtos.request.AsignadosRequestDTO;
import com.kernotec.test.jpa.entity.Asignados;

import java.util.List;
import java.util.UUID;

public interface IAsignadosService {
    List<Asignados> findAllByClienteId(UUID id);
    DefaultResponseDTO<Asignados> save(AsignadosRequestDTO dto);
}
