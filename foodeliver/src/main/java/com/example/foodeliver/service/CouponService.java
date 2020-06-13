package com.example.foodeliver.service;

import com.example.foodeliver.entity.Coupon;
import com.example.foodeliver.repository.CouponRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    public Coupon couponFactroyMethod(){
        return new Coupon();
    }

    public void saveCoupon(Coupon coupon) {
        couponRepository.save(coupon);
    }

    public List<Coupon> getAllCoupons(){
        return couponRepository.findAll();
    }
}
