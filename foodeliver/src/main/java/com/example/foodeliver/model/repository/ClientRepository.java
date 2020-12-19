package com.example.foodeliver.model.repository;

import com.example.foodeliver.model.entity.users.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client getClientByUsername(String username);
}
