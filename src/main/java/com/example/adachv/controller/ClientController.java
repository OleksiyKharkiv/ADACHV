package com.example.adachv.controller;

import com.example.adachv.entity.Client;
import com.example.adachv.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client with id " + id + " not found."));
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
        Client existingClient = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client with id " + id + " not found."));
        existingClient.setFullName(updatedClient.getFullName());
        // Дополнительные поля, если есть, для обновления

        return clientRepository.save(existingClient);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }
}