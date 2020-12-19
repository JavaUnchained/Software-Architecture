package com.example.foodeliver.model.repository;

import com.example.foodeliver.model.entity.users.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {
    Courier getCourierByUsername(String username);
}
