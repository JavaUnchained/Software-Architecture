package com.example.foodeliver.repository;

import com.example.foodeliver.entity.users.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client getPassengerByUsername(String username);
}
