package com.example.foodeliver.controller;

import com.example.foodeliver.entity.Order;
import com.example.foodeliver.entity.status.OrderPayStatus;
import com.example.foodeliver.service.OperatorService;
import com.example.foodeliver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OperatorController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OperatorService operatorService;

    @GetMapping("/operator_order")
    public String operatorOrder(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "operator_order";
    }

    @PostMapping("/operator_order")
    public String rationsSumbit(@RequestParam Long id,
                                Model model) {
        Order order = orderService.orderById(id);
        order.setStatus(OrderPayStatus.CONFIRMED);



        model.addAttribute("orders", orderService.getAllOrders());
        return "operator_order";
    }
}
