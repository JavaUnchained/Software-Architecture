package com.example.foodeliver.repository;

import com.example.foodeliver.entity.users.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {
    Courier getCourierByUsername(String username);
}
