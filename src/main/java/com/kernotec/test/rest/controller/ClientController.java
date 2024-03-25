package com.kernotec.test.rest.controller;

import com.kernotec.test.jpa.entity.Client;
import com.kernotec.test.jpa.service.ClientDbService;

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
public class ClientController {

	@Autowired
	private ClientDbService service;

	@Operation(summary = "Create a new client")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Client created",
            content = { @Content(mediaType = "application/json",
                schema = @Schema(implementation = Client.class)) }),
    })

    @PostMapping("/client")
    public Client createClient(@RequestBody Client client) {
        return service.createClient(client);
    }
    @Operation(summary = "Get all clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get the list of the clients",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
    })
    @GetMapping("/client")
    public List<Client> getClients(){
        return service.getAllClients();
    }

    @Operation(summary = "Get Client By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get client by Id",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
    })
    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable UUID id){
        return service.getClientById(id);
    }

    @Operation(summary = "Update Client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update client",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
    })
    @PutMapping("/client/{id}")
    public Client updateClient(@PathVariable UUID id, @RequestBody Client client)
    {
        client.setClientId(id);
        return service.modifyClient(client);
    }

    @Operation(summary = "Delete Client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete client",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
    })
    @DeleteMapping("/client")
    public void deleteClient(@RequestParam UUID id)
    {
        service.removeClient(id);
    }


}
