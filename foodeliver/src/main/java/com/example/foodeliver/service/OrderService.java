package com.example.foodeliver.service;

import com.example.foodeliver.model.entity.Adress;
import com.example.foodeliver.model.entity.Order;
import com.example.foodeliver.model.entity.Ration;
import com.example.foodeliver.model.entity.status.OrderPayStatus;
import com.example.foodeliver.model.entity.status.SubscribeStatusEnum;
import com.example.foodeliver.model.repository.OrderRepository;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @NotNull
    public static Order getOrderOne(@NotNull final OrderPayStatus status,
                                    @NotNull final Adress adress,
                                    @NotNull final LocalDate shippingDate,
                                    @NotNull final SubscribeStatusEnum subscrabeStatusEnum,
                                    @NotNull final Ration ration){
        return new Order(status,adress,shippingDate,subscrabeStatusEnum,ration);
    }

    @NotNull
    public Order orderById(@NotNull final Long id) {
        final Optional<Order> orderOptional = orderRepository.findById(id);
        return orderOptional.orElseThrow(IllegalArgumentException::new);
    }

    public void saveOrder(@NotNull final Order order){
        orderRepository.save(order);
    }

    @NotNull
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}
