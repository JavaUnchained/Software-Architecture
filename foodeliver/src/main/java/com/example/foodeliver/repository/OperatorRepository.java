package com.example.foodeliver.repository;

import com.example.foodeliver.domain.users.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<Operator, Long> {
    Operator getOperatorByUsername(String username);
}
