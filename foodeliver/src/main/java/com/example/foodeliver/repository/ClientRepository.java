package com.example.foodeliver.repository;

import com.example.foodeliver.domain.users.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client getClientByUsername(String username);
}
