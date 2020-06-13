package com.example.foodeliver.service;

import com.example.foodeliver.entity.Adress;
import com.example.foodeliver.entity.Coupon;
import com.example.foodeliver.entity.status.CouponStatusEnum;
import com.example.foodeliver.repository.CouponRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Getter
@Setter
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    public Coupon getCouponById(Long id){
        return couponRepository.findById(id).get();
    }

    public List<Coupon> getAllCouponsForCook(){
        return couponRepository.findAllByCouponStatusEnum_Awaiting();
    }

    public List<Coupon> getAllCouponsForCourier() {
        return couponRepository.findAllByCouponStatusEnum_CookedAndCouponStatusEnum_BackDellivered();
    }

    public Coupon couponFactroyMethod(String name, CouponStatusEnum couponStatusEnum, Adress adress, LocalDate shippingDate){
        return new Coupon(name,  couponStatusEnum, adress, shippingDate);
    }

    public void saveCoupon(Coupon coupon) {
        couponRepository.save(coupon);
    }

    public List<Coupon> getAllCoupons(){
        return couponRepository.findAll();
    }
}
