package com.kernotec.test.jpa.service;

import com.kernotec.test.domain.dtos.DefaultResponseDTO;
import com.kernotec.test.domain.dtos.request.VehiculoRequestDTO;
import com.kernotec.test.domain.exceptions.EntityNotFoundException;
import com.kernotec.test.domain.helpers.VehiculosHelper;
import com.kernotec.test.jpa.entity.Asignados;
import com.kernotec.test.jpa.entity.Vehiculos;
import com.kernotec.test.jpa.repository.VehiculosRepository;
import com.kernotec.test.jpa.service.interfaces.IVehiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehiculosService implements IVehiculosService {

    @Autowired
    private VehiculosRepository vehiculosRepository;

    @Autowired
    private AsignadosService asignadosService;

    public DefaultResponseDTO<Vehiculos> save(VehiculoRequestDTO dto) {
        Vehiculos vehiculoCreado = vehiculosRepository.save(VehiculosHelper.toEntity(dto));
        return DefaultResponseDTO.<Vehiculos>builder()
                .httpStatus(HttpStatus.CREATED)
                .message("Vehiculo creado correctamente.")
                .response(vehiculoCreado)
                .build();
    }

    public DefaultResponseDTO<List<Vehiculos>> getAll() {
        List<Vehiculos> vehiculos = vehiculosRepository.findAll();
        return DefaultResponseDTO.<List<Vehiculos>>builder()
                .httpStatus(HttpStatus.OK)
                .message("Vehiculos obtenidos correctamente.")
                .response(vehiculos)
                .build();
    }

    public DefaultResponseDTO<List<Vehiculos>> getAllByCostumer(UUID id) {
        List<Asignados> asignados = asignadosService.findAllByClienteId(id);
        List<Vehiculos> vehiculos = vehiculosRepository.findAll();
        List<Vehiculos> vehiculosAsignados = new ArrayList<>();
        asignados.forEach(x -> {
            Optional<Vehiculos> vehiculosFinded = vehiculos.stream()
                    .filter(vehiculos1 -> vehiculos1.getId().equals(x.getVehiculoId()))
                    .findFirst();
            vehiculosAsignados.add(vehiculosFinded.get());
        });
        return DefaultResponseDTO.<List<Vehiculos>>builder()
                .httpStatus(HttpStatus.OK)
                .message("Vehiculos obtenidos correctamente.")
                .response(vehiculosAsignados)
                .build();
    }

    public Vehiculos getById(UUID id) {
        Optional<Vehiculos> vehiculos = vehiculosRepository.findById(id);
        if(vehiculos.isEmpty()) {
            throw new EntityNotFoundException(Vehiculos.class.toString());
        }
        return vehiculos.get();
    }

    public DefaultResponseDTO<Vehiculos> update(UUID id, VehiculoRequestDTO dto) {
        Vehiculos vehiculos = getById(id);
        Vehiculos vehiculosActualizado = VehiculosHelper.toEntity(dto);
        vehiculosActualizado.setId(vehiculos.getId());
        Vehiculos clientesUpdated = vehiculosRepository.save(vehiculosActualizado);
        return DefaultResponseDTO.<Vehiculos>builder()
                .httpStatus(HttpStatus.OK)
                .message("Clientes Actualizado correctamente.")
                .response(clientesUpdated)
                .build();
    }

    public DefaultResponseDTO<Vehiculos> delete(UUID id) {
        Vehiculos vehiculos = getById(id);
        vehiculos.setDeleted(Boolean.TRUE);
        Vehiculos vehiculoEliminado = vehiculosRepository.save(vehiculos);
        return DefaultResponseDTO.<Vehiculos>builder()
                .httpStatus(HttpStatus.OK)
                .message("Vehiculo eliminado correctamente.")
                .response(vehiculoEliminado)
                .build();

    }

}
