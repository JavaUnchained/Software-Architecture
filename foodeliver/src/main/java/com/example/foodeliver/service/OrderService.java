package com.example.foodeliver.service;

import com.example.foodeliver.domain.Adress;
import com.example.foodeliver.domain.Order;
import com.example.foodeliver.domain.Ration;
import com.example.foodeliver.domain.status.OrderPayStatus;
import com.example.foodeliver.domain.status.SubscrabeStatusEnum;
import com.example.foodeliver.repository.OrderRepository;
import lombok.Getter;
import lombok.Setter;
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

    public Order orderFactoryMethod(OrderPayStatus status, Adress adress,
                                    LocalDate shippingDate, SubscrabeStatusEnum subscrabeStatusEnum, Ration ration){
        return new Order(status,adress,shippingDate,subscrabeStatusEnum,ration);
    }

    public Order orderById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        return orderOptional.get();
    }

    public void saveOrder(Order order){
        orderRepository.save(order);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}
