package com.kernotec.test.rest.controller;

import com.kernotec.test.jpa.entity.Cliente;
import com.kernotec.test.jpa.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping("/create")
    public void createCliente(@RequestBody Cliente cliente){
        clienteService.createCliente(cliente);
    }

    @GetMapping("/show")
    public List<Cliente> getAllClientes(){
        return clienteService.getAllClientes();
    }


    @PatchMapping("/update/{id}")
    public void updateCliente(@RequestBody Cliente cliente){
        clienteService.updateCliente(null, cliente);
    }
    


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        try {
            clienteService.deleteCliente(id);
            return new ResponseEntity<>("Cliente eliminado correctamente", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>("Cliente no encontrado con ID: " + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
