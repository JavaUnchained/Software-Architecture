package com.example.foodeliver.repository;

import com.example.foodeliver.entity.Coupon;
import com.example.foodeliver.entity.status.CouponStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    List<Coupon> getAllByCouponStatusEnum(CouponStatusEnum couponStatusEnum); // for Cook and Couriers
}
