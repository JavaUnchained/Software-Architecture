package com.example.foodeliver.controller;

import com.example.foodeliver.entity.Adress;
import com.example.foodeliver.entity.Coupon;
import com.example.foodeliver.entity.Order;
import com.example.foodeliver.entity.status.CouponStatusEnum;
import com.example.foodeliver.entity.status.OrderPayStatus;
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
        Operator operator = getCurrentOperator();
        CouponStatusEnum couponStatusEnum;
        Double operatorBalance;

        if(order.getStatus() == OrderPayStatus.PAID){

            order.setStatus(OrderPayStatus.CONFIRMED);
            couponStatusEnum = CouponStatusEnum.AWAITING;
            operatorBalance = operator.getAccount().getBalance() + order.getRation().getPrice();

        }else if(order.getStatus() == OrderPayStatus.REFUNDABLE){

            couponStatusEnum = CouponStatusEnum.BACK_DELLIVERED;
            operatorBalance = operator.getAccount().getBalance() - order.getRation().getPrice();

        }else {
            couponStatusEnum = CouponStatusEnum.DONE;
            operatorBalance = operator.getAccount().getBalance();
        }

        operator.getAccount().setBalance(operatorBalance);
        Adress adress = order.getAdress();
        String name = order.getRation().getRationName();
        LocalDate shipingDate = order.getShippingDate();

        Coupon coupon = couponService.couponFactroyMethod(name, couponStatusEnum, adress, shipingDate);
        couponService.saveCoupon(coupon);

        model.addAttribute("orders", orderService.getAllOrders());
        return "operator_order";
    }

    @GetMapping("/operator_coupons")
    public String operatorCoupons(Model model) {
        model.addAttribute("coupons", couponService.getAllCoupons());
        return "operator_coupons";
    }

    public Operator getCurrentOperator() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return operatorService.getOperatorByUsername(currentPrincipalName);
    }

}
