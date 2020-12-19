package com.example.foodeliver.model.repository;

import com.example.foodeliver.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
