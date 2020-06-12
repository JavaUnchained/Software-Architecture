package com.example.foodeliver.repository;

import com.example.foodeliver.entity.Ration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RationRepository extends JpaRepository<Ration, Long> {
}
