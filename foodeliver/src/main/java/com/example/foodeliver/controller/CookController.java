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
@RequestMapping("/cook")
@CrossOrigin(origins = "http://localhost:4200")
public class CookController {
    @Autowired
    private CouponService couponService;

    @GetMapping("/cook_coupons")
    public @NotNull List<Coupon> cookCouponsGet() {
        return couponService.getAllCouponsForCook();
    }

    @PostMapping("/cook_coupons")
    public @NotNull ResponseEntity<?> cookCouponsPost(@NotNull @RequestParam final Long id) {
        couponService.changeToCooked(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
