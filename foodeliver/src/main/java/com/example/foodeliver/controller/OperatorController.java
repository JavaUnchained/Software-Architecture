package com.example.foodeliver.controller;

import com.example.foodeliver.entity.Adress;
import com.example.foodeliver.entity.Coupon;
import com.example.foodeliver.entity.Order;
import com.example.foodeliver.entity.Ration;
import com.example.foodeliver.entity.status.CouponStatusEnum;
import com.example.foodeliver.entity.status.OrderPayStatus;
import com.example.foodeliver.entity.status.SubscrabeStatusEnum;
import com.example.foodeliver.entity.users.Operator;
import com.example.foodeliver.repository.RationRepository;
import com.example.foodeliver.service.CouponService;
import com.example.foodeliver.service.OperatorService;
import com.example.foodeliver.service.OrderService;
import com.example.foodeliver.service.RationService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/operator")
@Getter @Setter
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
    public String rationsSumbit(@RequestParam Long id, Model model) {
        Order order = orderService.orderById(id);
        Operator operator = getCurrentOperator();
        CouponStatusEnum couponStatusEnum;
        Double operatorBalance;
        LocalDate shipingDate;

        if(order.getStatus() == OrderPayStatus.PAID){

            order.setStatus(OrderPayStatus.CONFIRMED);
            couponStatusEnum = CouponStatusEnum.AWAITING;
            operatorBalance = operator.getAccount().getBalance() + order.getRation().getPrice();

        }else if(order.getStatus() == OrderPayStatus.REFUNDABLE) {

            couponStatusEnum = CouponStatusEnum.BACK_DELLIVERED;
            operatorBalance = operator.getAccount().getBalance() - order.getRation().getPrice();

        }else{
            couponStatusEnum = CouponStatusEnum.DONE;
            operatorBalance = operator.getAccount().getBalance();
        }

        if(order.getSubscrabeStatusEnum() == SubscrabeStatusEnum.SUBSCRIBE
                    && order.getStatus() != OrderPayStatus.REFUNDABLE
                    && order.getStatus() != OrderPayStatus.REFUNDED) {
        order.getShippingDate().plusDays(30);
        order.setStatus(OrderPayStatus.PAID);
        }

        orderService.saveOrder(order);

        operator.getAccount().setBalance(operatorBalance);
        operatorService.saveOperatorState(operator);

        Adress adress = order.getAdress();
        String name = order.getRation().getRationName();
        shipingDate= order.getShippingDate();

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

    /*Наполнение рационов*/
    @Autowired
    private RationService rationService;
//    @Autowired
//    private RationRepository rationRepository;

    @GetMapping("/rations")
    public String rations(Model model) {
        model.addAttribute("rations", rationService.getAllRations());
        return "rations";
    }

    @PostMapping("/rations")
    public String rationsSumbit(@RequestParam String name,
                                @RequestParam Double price,
                                @RequestParam String description,
                                Model model) {
//        Ration ration = rationService.rationFactoryMethod(name,price,description);
        Ration ration = rationService.rationFactoryMethod(name,price,description);
        rationService.saveRation(ration);

        model.addAttribute("rations", rationService.getAllRations());
        return "rations";
    }
}
