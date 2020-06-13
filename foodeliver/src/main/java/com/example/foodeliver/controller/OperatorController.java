package com.example.foodeliver.controller;

import com.example.foodeliver.entity.Adress;
import com.example.foodeliver.entity.Coupon;
import com.example.foodeliver.entity.Order;
import com.example.foodeliver.entity.status.CouponStatusEnum;
import com.example.foodeliver.entity.status.OrderPayStatus;
import com.example.foodeliver.entity.users.Client;
import com.example.foodeliver.entity.users.Operator;
import com.example.foodeliver.service.CouponService;
import com.example.foodeliver.service.OperatorService;
import com.example.foodeliver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class OperatorController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private CouponService couponService;

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

        Operator operator = getCurrentOperator();

        Double operatorBalance = operator.getAccount().getBalance() + order.getRation().getPrice();
        operator.getAccount().setBalance(operatorBalance);

        Adress adress = order.getAdress();
        CouponStatusEnum couponStatusEnum = CouponStatusEnum.AWAITING;
        String name = order.getRation().getRationName();
        LocalDate shipingDate = order.getShippingDate();

        couponService.couponFactroyMethod();

        model.addAttribute("orders", orderService.getAllOrders());
        return "operator_order";
    }

    public Operator getCurrentOperator() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return operatorService.getOperatorByUsername(currentPrincipalName);
    }
}
