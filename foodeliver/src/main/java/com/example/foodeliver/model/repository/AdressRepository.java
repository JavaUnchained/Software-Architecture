package com.example.foodeliver.model.repository;

import com.example.foodeliver.model.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress, Long> {
}
