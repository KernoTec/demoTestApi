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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AsignadosService implements IAsignadosService {

    @Autowired
    private AsignadosRepository asignadosRepository;

    public List<Asignados> findAllByClienteId(UUID id) {
        List<Asignados> asignados = asignadosRepository.findAllByClienteId(id);
        return asignados;
    }

    public DefaultResponseDTO<Asignados> save(AsignadosRequestDTO dto) {
        Asignados asignadosCreated = asignadosRepository.save(AsignadosHelper.toEntity(dto));
        return DefaultResponseDTO.<Asignados>builder()
                .httpStatus(HttpStatus.CREATED)
                .message("Vehiculo asignado creado correctamente.")
                .response(asignadosCreated)
                .build();
    }

    public Asignados getById(UUID id) {
        Optional<Asignados> asignados = asignadosRepository.findById(id);
        if(asignados.isEmpty()) {
            throw new EntityNotFoundException(Clientes.class.getSimpleName());
        }
        return asignados.get();
    }

}
