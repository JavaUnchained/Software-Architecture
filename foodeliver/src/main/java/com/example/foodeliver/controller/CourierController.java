package com.example.foodeliver.controller;

import com.example.foodeliver.entity.Coupon;
import com.example.foodeliver.entity.status.CouponStatusEnum;
import com.example.foodeliver.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/courier")
public class CourierController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/courier_coupons")
    public String courierCouponsGet(Model model) {
        model.addAttribute("coupons", couponService.getAllCouponsForCourier());
        return "courier_coupons";
    }


    @PostMapping("/courier_coupons")
    public String courierCouponsPost(@RequestParam Long id, Model model) {
        final Coupon coupon =  couponService.getCouponById(id);
        if(coupon.getCouponStatusEnum() == CouponStatusEnum.BACK_DELLIVERED){
            coupon.setCouponStatusEnum(CouponStatusEnum.REFUND);
        }else{
            coupon.setCouponStatusEnum(CouponStatusEnum.DELIVERY);
        }
        couponService.saveCoupon(coupon);
        model.addAttribute("coupons", couponService.getAllCouponsForCourier());
        return "courier_coupons";
    }
}
