package com.example.foodeliver.model.repository;

import com.example.foodeliver.model.entity.users.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<Operator, Long> {
    Operator getOperatorByUsername(String username);
}
