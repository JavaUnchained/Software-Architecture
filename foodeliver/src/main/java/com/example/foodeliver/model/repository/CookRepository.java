package com.example.foodeliver.model.repository;

import com.example.foodeliver.model.entity.users.Cook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookRepository extends JpaRepository<Cook, Long> {
}
