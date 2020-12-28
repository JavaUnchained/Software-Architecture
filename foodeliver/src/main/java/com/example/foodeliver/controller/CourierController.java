package com.example.foodeliver.controller;

import com.example.foodeliver.model.dto.CourierCouponDTO;
import com.example.foodeliver.service.CouponService;
import com.example.foodeliver.service.OrderService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courier")
@CrossOrigin(origins = "*")
public class CourierController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/coupons")
    public @NotNull List<CourierCouponDTO> courierCoupons() {
        return couponService.getAllCouponsForCourier().stream().map(coupon ->
                new CourierCouponDTO(coupon.getId(), OrderService.getFullAddress(coupon.getAdress()),
                        coupon.getCouponStatusEnum().toString(), coupon.getShippingDate().toString()))
                .collect(Collectors.toList());
    }


    @PostMapping("/coupons")
    public @NotNull ResponseEntity<?> courierCoupons(@RequestBody @NotNull final Long id) {
        couponService.changeToRefundOrDelivery(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
