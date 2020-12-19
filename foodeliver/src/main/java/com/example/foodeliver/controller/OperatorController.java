package com.example.foodeliver.controller;

import com.example.foodeliver.dto.RationDTO;
import com.example.foodeliver.entity.Coupon;
import com.example.foodeliver.entity.Order;
import com.example.foodeliver.entity.Ration;
import com.example.foodeliver.service.CouponService;
import com.example.foodeliver.service.OperatorService;
import com.example.foodeliver.service.OrderService;
import com.example.foodeliver.service.RationService;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operator")
@Getter @Setter
@CrossOrigin(origins = "http://localhost:4200")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private RationService rationService;

    @GetMapping("/operator_order")
    public @NotNull List<Order> operatorOrder() {
        return orderService.getAllOrders();
    }

    @PostMapping("/operator_order")
    public @NotNull List<Order> rationsSubmit(@NotNull @RequestParam final Long id) {
        operatorService.submit(id);
        return orderService.getAllOrders();
    }

    @GetMapping("/operator_coupons")
    public @NotNull List<Coupon> operatorCoupons() {
        return couponService.getAllCoupons();
    }

    @GetMapping("/rations")
    public @NotNull List<Ration> rations() {
        return rationService.getAllRations();
    }

    @PostMapping("/rations")
    public @NotNull ResponseEntity<Object> rationsSubmit(@RequestBody @NotNull final RationDTO rationDTO) {
        rationService.saveRation(
                rationService.getRationOne(
                        rationDTO.getName(),
                        rationDTO.getPrice(),
                        rationDTO.getDescription()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
