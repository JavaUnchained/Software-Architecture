package com.example.foodeliver.service;

import com.example.foodeliver.entity.Adress;
import com.example.foodeliver.entity.Order;
import com.example.foodeliver.entity.Ration;
import com.example.foodeliver.entity.status.OrderPayStatus;
import com.example.foodeliver.entity.status.SubscrabeStatusEnum;
import com.example.foodeliver.repository.OrderRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public void saveOrder(Order order){
        orderRepository.save(order);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}
