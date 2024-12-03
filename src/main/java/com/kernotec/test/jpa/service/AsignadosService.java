package com.kernotec.test.jpa.service;

import com.kernotec.test.domain.dtos.DefaultResponseDTO;
import com.kernotec.test.domain.dtos.request.AsignadosRequestDTO;
import com.kernotec.test.domain.dtos.request.VehiculoRequestDTO;
import com.kernotec.test.domain.exceptions.EntityNotFoundException;
import com.kernotec.test.domain.helpers.AsignadosHelper;
import com.kernotec.test.domain.helpers.VehiculosHelper;
import com.kernotec.test.jpa.entity.Asignados;
import com.kernotec.test.jpa.entity.Clientes;
import com.kernotec.test.jpa.entity.Vehiculos;
import com.kernotec.test.jpa.repository.AsignadosRepository;
import com.kernotec.test.jpa.repository.VehiculosRepository;
import com.kernotec.test.jpa.service.interfaces.IAsignadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AsignadosService implements IAsignadosService {

    @Autowired
    private AsignadosRepository asignadosRepository;

    @Autowired
    private VehiculosRepository vehiculosRepository;


    @Override
    public DefaultResponseDTO<List<Vehiculos>> findAllByClienteId(UUID id) {
        List<Asignados> asignadosList = asignadosRepository.findAllByClienteId(id);
        List<Vehiculos> vehiculosList = new ArrayList<>();
        asignadosList.forEach(asignado -> {
            vehiculosList.add(vehiculosRepository.findById(asignado.getVehiculoId()).orElseThrow(EntityNotFoundException::new));
        });
        return DefaultResponseDTO.<List<Vehiculos>>builder()
                .httpStatus(HttpStatus.OK)
                .message("Vehiculos asignados obtenidos correctamente.")
                .response(vehiculosList)
                .build();
    }

    public DefaultResponseDTO<Asignados> save(AsignadosRequestDTO dto) {
        Asignados asignadosCreated = asignadosRepository.save(AsignadosHelper.toEntity(dto));
        return DefaultResponseDTO.<Asignados>builder()
                .httpStatus(HttpStatus.CREATED)
                .message("Vehiculo asignado creado correctamente.")
                .response(asignadosCreated)
                .build();
    }

    public DefaultResponseDTO<List<Vehiculos>> getById(UUID id) {
        List<Asignados> asignados = asignadosRepository.findAllByClienteId(id);
        List<Vehiculos> vehiculosAsignados = new ArrayList<>();
        if(asignados.size()>0){
            List<Vehiculos> vehiculos = vehiculosRepository.findAll();
            asignados.forEach(x -> {
                vehiculosAsignados.add(getByIdVehiculo(x.getVehiculoId()));
            });
        }
        return DefaultResponseDTO.<List<Vehiculos>>builder()
                .httpStatus(HttpStatus.CREATED)
                .message("Vehiculos asignados obtenidos correctamente.")
                .response(vehiculosAsignados)
                .build();
    }

    public Vehiculos getByIdVehiculo(UUID id) {
        Optional<Vehiculos> vehiculos = vehiculosRepository.findById(id);
        if(vehiculos.isEmpty()) {
            throw new EntityNotFoundException(Vehiculos.class.toString());
        }
        return vehiculos.get();
    }

}
