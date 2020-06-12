package com.example.foodeliver.repository;

import com.example.foodeliver.entity.person.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {
    Courier getDriverByUsername(String username);
}