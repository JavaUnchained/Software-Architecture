package com.example.foodeliver.repository;

import com.example.foodeliver.domain.Ration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RationRepository extends JpaRepository<Ration, Long> {
    Ration getRationByRationName(String name);
}
