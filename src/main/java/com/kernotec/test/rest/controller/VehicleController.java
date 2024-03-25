package com.kernotec.test.rest.controller;

import com.kernotec.test.jpa.entity.Client;
import com.kernotec.test.jpa.entity.Vehicle;
import com.kernotec.test.jpa.service.VehicleDbService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/")
@RestController
public class VehicleController {

    @Autowired
    private VehicleDbService service;

    @Operation(summary = "Create a new vehicle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "vehicle created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
    })
    @PostMapping("/vehicle")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return service.createVechicle(vehicle);
    }
    @Operation(summary = "Get the list of vehicles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "list of the vehicles",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
    })
    @GetMapping("/vehicle")
    public List<Vehicle> getAllVehicles(){
        return service.getAllVehicles();
    }

    @Operation(summary = "Get vehicle by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "vehicle found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
    })
    @GetMapping("/vehicle/{id}")
    public Vehicle getVehicleById(@PathVariable UUID id){
        return service.getVehicleById(id);
    }

    @Operation(summary = "Update a vehicle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "vehicle updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
    })
    @PutMapping("/vehicle/{id}")
    public Vehicle updateVehicle(@PathVariable UUID id, @RequestBody Vehicle vehicle) {
        vehicle.setVehicleId(id);
        return service.modifyVehicle(vehicle);
    }
    @Operation(summary = "Delete a vehicle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "vehicle deleted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
    })
    @DeleteMapping("/vehicle")
    public void deleteClient(@RequestParam UUID id){service.removeVehicle(id);}

    @Operation(summary = "Get vehicles from a client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "vehicles from client",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
    })
    @GetMapping("/vehicles/{id}")
    public List<Vehicle> getVehiclesByClient(@RequestParam UUID id){ return  service.getVehiclesByClientId(id);}
}
