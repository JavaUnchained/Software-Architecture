package com.example.foodeliver.controller;

import com.example.foodeliver.entity.Coupon;
import com.example.foodeliver.service.CouponService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courier")
@CrossOrigin(origins = "http://localhost:4200")
public class CourierController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/courier_coupons")
    public @NotNull List<Coupon> courierCouponsGet() {
        return couponService.getAllCouponsForCourier();
    }


    @PostMapping("/courier_coupons")
    public @NotNull List<Coupon> courierCouponsPost(@RequestParam final Long id) {
        couponService.changeToRefundOrDelivery(id);
        return couponService.getAllCouponsForCourier();
    }
}
