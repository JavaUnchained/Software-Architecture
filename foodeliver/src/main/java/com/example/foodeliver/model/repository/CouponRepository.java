package com.example.foodeliver.model.repository;

import com.example.foodeliver.model.entity.Adress;
import com.example.foodeliver.model.entity.Coupon;
import com.example.foodeliver.model.entity.status.CouponStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    List<Coupon> getAllByCouponStatusEnum(CouponStatusEnum couponStatusEnum); // for Cook and Couriers

    Coupon getByAdressAndShippingDateAndName(Adress adress, LocalDate shippingDate, String name);
}
