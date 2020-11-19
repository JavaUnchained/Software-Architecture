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
@RequestMapping("/cook")
public class CoockController {
    @Autowired
    private CouponService couponService;

    @GetMapping("/cook_coupons")
    public String cookCouponsGet(Model model) {
        model.addAttribute("coupons", couponService.getAllCouponsForCook());
        return "cook_coupons";
    }

    @PostMapping("/cook_coupons")
    public String cookCouponsPost(@RequestParam Long id, Model model) {
        final Coupon coupon =  couponService.getCouponById(id);
        coupon.setCouponStatusEnum(CouponStatusEnum.COOKED);
        couponService.saveCoupon(coupon);
        model.addAttribute("coupons", couponService.getAllCouponsForCook());
        return "cook_coupons";
    }

}
