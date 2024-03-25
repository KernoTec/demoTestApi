package com.kernotec.test.jpa.service;

import com.kernotec.test.jpa.entity.Client;
import com.kernotec.test.jpa.repository.IClientDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientDbService {

    @Autowired
    private IClientDbRepository clientRepository;

    public Client createClient(Client client) {
    	return clientRepository.save(client);
    }
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    public Client getClientById(UUID id) { Optional<Client> client = clientRepository.findById(id); if (client.isPresent()){return client.get();} throw  new RuntimeException("Client is not found with id :" + id);}
    public Client modifyClient(Client client) {return clientRepository.save(client);}
    public void removeClient(UUID id) { clientRepository.deleteById(id);}


}
