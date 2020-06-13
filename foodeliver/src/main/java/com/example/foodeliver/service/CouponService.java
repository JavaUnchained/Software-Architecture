package com.example.foodeliver.service;

import com.example.foodeliver.domain.Adress;
import com.example.foodeliver.domain.Coupon;
import com.example.foodeliver.domain.status.CouponStatusEnum;
import com.example.foodeliver.repository.CouponRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
        return couponRepository.getAllByCouponStatusEnum(CouponStatusEnum.AWAITING);
    }

    public List<Coupon> getAllCouponsForCourier() {
        List<Coupon> coupons1 = couponRepository.getAllByCouponStatusEnum(CouponStatusEnum.COOKED);
        List<Coupon> coupons2 = couponRepository.getAllByCouponStatusEnum(CouponStatusEnum.REFUND);
        List<Coupon> couponsFinal = new ArrayList<>();
        couponsFinal.addAll(coupons1);
        couponsFinal.addAll(coupons2);
        return couponsFinal;
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
