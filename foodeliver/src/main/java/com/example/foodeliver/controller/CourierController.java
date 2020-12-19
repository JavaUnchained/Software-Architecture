package com.example.foodeliver.controller;

import com.example.foodeliver.model.entity.Coupon;
import com.example.foodeliver.service.CouponService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courier")
@CrossOrigin(origins = "http://localhost:4200")
public class CourierController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/coupons")
    public @NotNull List<Coupon> courierCoupons() {
        return couponService.getAllCouponsForCourier();
    }


    @PostMapping("/coupons")
    public @NotNull ResponseEntity<?> courierCoupons(@RequestParam @NotNull final Long id) {
        couponService.changeToRefundOrDelivery(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
