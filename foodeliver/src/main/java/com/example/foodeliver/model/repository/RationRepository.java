package com.example.foodeliver.model.repository;

import com.example.foodeliver.model.entity.Ration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RationRepository extends JpaRepository<Ration, Long> {
    Ration getRationByRationName(String name);
    Ration getRationById(Long id);
}
