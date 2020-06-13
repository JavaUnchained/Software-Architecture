package com.example.foodeliver.repository;

import com.example.foodeliver.domain.users.Cook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookRepository extends JpaRepository<Cook, Long> {
}
