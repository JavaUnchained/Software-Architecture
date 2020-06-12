package com.example.foodeliver.service;

import com.example.foodeliver.entity.users.Client;
import com.example.foodeliver.repository.ClientRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void savePassenger(Client client) {
        clientRepository.save(client);
    }

    public Client getClientByUsername(String username) {
        Client client = clientRepository.getPassengerByUsername(username);
        return client;
    }

    public List<Client> getPassengers() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }
}
