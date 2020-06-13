package com.example.foodeliver.service;

import com.example.foodeliver.entity.Coupon;
import com.example.foodeliver.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    public void saveCoupon(Coupon coupon) {
        couponRepository.save(coupon);
    }

    public List<Coupon> getAllCoupons(){
        return
    }
}
