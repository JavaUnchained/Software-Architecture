package com.example.foodeliver.controller;

import com.example.foodeliver.model.dto.CouponDTO;
import com.example.foodeliver.model.dto.OrderResponseDTO;
import com.example.foodeliver.model.dto.Ration;
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
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/operator")
@Getter @Setter
@CrossOrigin(origins = "*")
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
    public @NotNull List<OrderResponseDTO> operatorOrder() {
        return orderService.getAllOrders().stream().map(order -> new OrderResponseDTO(
                order.getId(),
                order.getRation().getRationName(),
                order.getShippingDate().toString(),
                order.getStatus().toString(),
                order.getSubscrabeStatusEnum().toString(),
                OrderService.getFullAddress(order.getAdress())
        )).collect(Collectors.toList());
    }

    @PostMapping("/orders")
    public @NotNull ResponseEntity<?> confirmOrder(@NotNull @RequestBody final Long id) {
        operatorService.submit(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_order")
    public @NotNull ResponseEntity<?> deleteOrder(@NotNull @RequestParam final Long id) {
        rationService.getRationRepository().deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/operator_coupons")
    public @NotNull List<CouponDTO> operatorCoupons() {
        return couponService.getAllCoupons().stream().map(coupon ->
                new CouponDTO(
                        coupon.getId(),
                        OrderService.getFullAddress(coupon.getAdress()),
                        coupon.getCouponStatusEnum().toString(),
                        coupon.getName(),
                        coupon.getShippingDate().toString()
                        )).collect(Collectors.toList());
    }

    @GetMapping("/rations")
    public @NotNull List<Ration> rations() {
        return rationService.getAllRations().stream().map(r -> new Ration(r.getId(), r.getRationName(),
                r.getRationDescription(), r.getPrice())).collect(Collectors.toList());
    }

    @PostMapping("/rations")
    public @NotNull ResponseEntity<?> rationsSubmit(@RequestBody @NotNull final Ration rd) {
        if(List.of(rd.getName(), rd.getDescription(), rd.getPrice()).stream().anyMatch(Objects::isNull))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        rationService.saveRation(RationService.getRationOne(rd.getName(), rd.getPrice(), rd.getDescription()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_ration")
    public @NotNull ResponseEntity<?> deleteRation(@RequestParam @NotNull final Long id) {
        rationService.getRationRepository().deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/deleterations")
    public @NotNull ResponseEntity<?> deleteRations(@RequestBody @NotNull final Long[] ids) {
        Arrays.stream(ids).forEach(id -> rationService.getRationRepository().deleteById(id));
        System.out.println("yeah");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
