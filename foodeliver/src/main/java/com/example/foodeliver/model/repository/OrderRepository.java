package com.example.foodeliver.model.repository;

import com.example.foodeliver.model.entity.Adress;
import com.example.foodeliver.model.entity.Order;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getAllByClient_Name(@NotNull final String clientName);

    List<Order> getAllByClient_Id(@NotNull final Long id);

    Order getByAdress(@NotNull final Adress address);
}
