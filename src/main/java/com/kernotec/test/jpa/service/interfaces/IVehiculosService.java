package com.kernotec.test.jpa.service.interfaces;

import com.kernotec.test.domain.dtos.DefaultResponseDTO;
import com.kernotec.test.domain.dtos.request.VehiculoRequestDTO;
import com.kernotec.test.jpa.entity.Vehiculos;

import java.util.List;
import java.util.UUID;

public interface IVehiculosService {
    DefaultResponseDTO<Vehiculos> save(VehiculoRequestDTO dto);
    DefaultResponseDTO<List<Vehiculos>> getAll();
    DefaultResponseDTO<List<Vehiculos>> getAllByCostumer(UUID id);
    DefaultResponseDTO<Vehiculos> update(UUID id, VehiculoRequestDTO dto);
    DefaultResponseDTO<Vehiculos> delete(UUID id);
}
