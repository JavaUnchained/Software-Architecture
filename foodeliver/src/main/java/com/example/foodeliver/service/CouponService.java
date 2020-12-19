package com.example.foodeliver.service;

import com.example.foodeliver.entity.Adress;
import com.example.foodeliver.entity.Coupon;
import com.example.foodeliver.entity.status.CouponStatusEnum;
import com.example.foodeliver.repository.CouponRepository;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
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

    @NotNull
    public Coupon getCouponById(@NotNull final Long id){
        return couponRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public List<Coupon> getAllCouponsForCook(){
        return couponRepository.getAllByCouponStatusEnum(CouponStatusEnum.AWAITING);
    }

    @NotNull
    public List<Coupon> getAllCouponsForCourier() {
        final List<Coupon> cookedAndRefunded = new ArrayList<>();
        cookedAndRefunded.addAll(couponRepository.getAllByCouponStatusEnum(CouponStatusEnum.COOKED));
        cookedAndRefunded.addAll(couponRepository.getAllByCouponStatusEnum(CouponStatusEnum.REFUND));
        return cookedAndRefunded;
    }

    @NotNull
    public static Coupon couponFactoryMethod(@NotNull final String name,
                                             @NotNull final CouponStatusEnum couponStatusEnum,
                                             @NotNull final Adress adress,
                                             @NotNull final LocalDate shippingDate){
        return new Coupon(name,  couponStatusEnum, adress, shippingDate);
    }

    public void saveCoupon(@NotNull final Coupon coupon) {
        couponRepository.save(coupon);
    }

    public List<Coupon> getAllCoupons(){
        return couponRepository.findAll();
    }

    public void changeToRefundOrDelivery(@NotNull final Long id) {
        final Coupon coupon =  getCouponById(id);
        if(coupon.getCouponStatusEnum() == CouponStatusEnum.BACK_DELLIVERED){
            coupon.setCouponStatusEnum(CouponStatusEnum.REFUND);
        }else{
            coupon.setCouponStatusEnum(CouponStatusEnum.DELIVERY);
        }
        saveCoupon(coupon);
    }

    public void changeToCooked(@NotNull final Long id) {
        final Coupon coupon =  getCouponById(id);
        coupon.setCouponStatusEnum(CouponStatusEnum.COOKED);
        saveCoupon(coupon);
    }
}
