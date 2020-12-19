package com.example.foodeliver.controller;

import com.example.foodeliver.model.dto.RationDTO;
import com.example.foodeliver.model.entity.Coupon;
import com.example.foodeliver.model.entity.Order;
import com.example.foodeliver.model.entity.Ration;
import com.example.foodeliver.service.CouponService;
import com.example.foodeliver.service.OperatorService;
import com.example.foodeliver.service.OrderService;
import com.example.foodeliver.service.RationService;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operator")
@Getter @Setter
@CrossOrigin(origins = "http://localhost:4200")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private RationService rationService;

    @GetMapping("/orders")
    public @NotNull List<Order> operatorOrder() {
        return orderService.getAllOrders();
    }

    @PostMapping("/orders")
    public @NotNull ResponseEntity<?> orderSubmit(@NotNull @RequestParam final Long id) {
        operatorService.submit(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_order")
    public @NotNull ResponseEntity<?> deleteOrder(@NotNull @RequestParam final Long id) {
        rationService.getRationRepository().deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/operator_coupons")
    public @NotNull List<Coupon> operatorCoupons() {
        return couponService.getAllCoupons();
    }

    @GetMapping("/rations")
    public @NotNull List<Ration> rations() {
        return rationService.getAllRations();
    }

    @PostMapping("/rations")
    public @NotNull ResponseEntity<?> rationsSubmit(@RequestBody @NotNull final RationDTO rd) {
        if(!rd.isAllFieldNonNull()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        rationService.saveRation(RationService.getRationOne(rd.getName(), rd.getPrice(), rd.getDescription()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_ration")
    public @NotNull ResponseEntity<?> deleteRation(@RequestParam @NotNull final Long id) {
        rationService.getRationRepository().deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
