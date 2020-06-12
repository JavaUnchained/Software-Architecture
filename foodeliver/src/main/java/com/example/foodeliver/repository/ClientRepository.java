package com.example.foodeliver.repository;

import com.example.foodeliver.entity.person.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client getPassengerByUsername(String username);
}