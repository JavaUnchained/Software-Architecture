package com.example.foodeliver.controller;

import com.example.foodeliver.model.dto.CookCouponDTO;
import com.example.foodeliver.service.CouponService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cook")
@CrossOrigin(origins = "*")
public class CookController {
    @Autowired
    private CouponService couponService;

    @GetMapping("/cook_coupons")
    public @NotNull List<CookCouponDTO> cookCouponsGet() {
        return couponService.getAllCouponsForCook().stream().map(coupon ->
                new CookCouponDTO(coupon.getId(), coupon.getName(), coupon.getShippingDate().toString()))
                .collect(Collectors.toList());
    }

    @PostMapping("/cook_coupons")
    public @NotNull ResponseEntity<?> cookCouponsPost(@NotNull @RequestBody final Long id) {
        couponService.changeToCooked(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
