package com.example.foodeliver.repository;

import com.example.foodeliver.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
