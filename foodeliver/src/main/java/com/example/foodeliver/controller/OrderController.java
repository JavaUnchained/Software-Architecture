package com.example.foodeliver.controller;

import com.example.foodeliver.entity.Order;
import com.example.foodeliver.entity.Ration;
import com.example.foodeliver.entity.status.OrderPayStatus;
import com.example.foodeliver.entity.users.Role;
import com.example.foodeliver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/client_order")
    public String clientOrder(Model model){
        model.addAttribute("orders", orderService.getAllOrders());
        return "client_order";
    }

    @PostMapping("/client_order")
    public String rationsSumbit(@RequestParam String name,
                                @RequestParam Double price,
                                @RequestParam String description,
                                Model model) {
        Order order = orderService.orderFactoryMethod(  OrderPayStatus.PAID,
                                                        );
        orderService.saveOrder(order);

        model.addAttribute("orders", orderService.getAllOrders());
        return "rations";
    }
}
