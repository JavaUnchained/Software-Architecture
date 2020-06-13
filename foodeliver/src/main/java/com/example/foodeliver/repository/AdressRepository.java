package com.example.foodeliver.repository;

import com.example.foodeliver.domain.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress, Long> {
}
