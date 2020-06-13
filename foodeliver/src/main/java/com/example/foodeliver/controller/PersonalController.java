package com.example.foodeliver.controller;

import com.example.foodeliver.entity.Coupon;
import com.example.foodeliver.entity.status.CouponStatusEnum;
import com.example.foodeliver.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*Contains cook and courier*/
@Controller
public class PersonalController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/cook_coupons")
    public String cookCouponsGet(Model model) {
        model.addAttribute("coupons", couponService.getAllCouponsForCook());
        return "cook_coupons";
    }

    @PostMapping("/cook_coupons")
    public String cookCouponsPost(@RequestParam Long id, Model model) {
        Coupon coupon =  couponService.getCouponById(id);
        coupon.setCouponStatusEnum(CouponStatusEnum.COOKED);
        model.addAttribute("coupons", couponService.getAllCouponsForCook());
        return "cook_coupons";
    }

    @GetMapping("/courier_coupons")
    public String courierCouponsGet(Model model) {
        model.addAttribute("coupons", couponService.getAllCouponsForCourier());
        return "courier_coupons";
    }


    @PostMapping("/courier_coupons")
    public String courierCouponsPost(@RequestParam Long id,Model model) {
        Coupon coupon =  couponService.getCouponById(id);
        coupon.setCouponStatusEnum(CouponStatusEnum.COOKED);
        model.addAttribute("coupons", couponService.getAllCouponsForCourier());
        return "courier_coupons";
    }
}
