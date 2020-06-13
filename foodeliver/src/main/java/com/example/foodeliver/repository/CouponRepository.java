package com.example.foodeliver.repository;

import com.example.foodeliver.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    List<Coupon>findAllByCouponStatusEnum_Awaiting(); // for Cook

    List<Coupon> findAllByCouponStatusEnum_CookedAndCouponStatusEnum_BackDellivered(); // for Couriers
}
