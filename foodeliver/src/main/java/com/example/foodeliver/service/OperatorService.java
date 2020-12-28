package com.example.foodeliver.service;

import com.example.foodeliver.model.entity.Coupon;
import com.example.foodeliver.model.entity.Order;
import com.example.foodeliver.model.entity.status.CouponStatusEnum;
import com.example.foodeliver.model.entity.status.OrderPayStatus;
import com.example.foodeliver.model.entity.status.SubscribeStatusEnum;
import com.example.foodeliver.model.entity.users.Operator;
import com.example.foodeliver.model.repository.OperatorRepository;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Getter
@Setter
public class OperatorService {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private OperatorRepository operatorRepository;

    @NotNull
    public Operator getOperatorByUsername(@NotNull final String username) {
        return operatorRepository.getOperatorByUsername(username);
    }

    public void saveOperatorState(@NotNull final Operator operator) {
        operatorRepository.save(operator);
    }

    public void submit(@NotNull final Long id) {
        final Order order = orderService.orderById(id);
//        final Operator operator = getCurrentOperator();
//        final Double operatorBalance;
        final CouponStatusEnum couponStatusEnum;
        final LocalDate shippingDate = order.getShippingDate();
        final LocalDate lastShippingDate = order.getShippingDate();
        if(isExtendSubscribe(order.getStatus(), order.getSubscrabeStatusEnum())) {
            order.setShippingDate(shippingDate.plusMonths(1));
            order.setStatus(OrderPayStatus.PAID);
        }
        switch (order.getStatus()) {
            case PAID:
                order.setStatus(OrderPayStatus.CONFIRMED);
                couponStatusEnum = CouponStatusEnum.AWAITING;
//                operatorBalance = operator.getAccount().getBalance() + order.getRation().getPrice();
                break;
            case REFUNDED:
                couponStatusEnum = CouponStatusEnum.BACK_DELLIVERED;
//                operatorBalance = operator.getAccount().getBalance() - order.getRation().getPrice();
                break;
            case DONE:
                if (order.getSubscrabeStatusEnum() == SubscribeStatusEnum.SINGLE) {
                    orderService.getOrderRepository().delete(order);
                }
            default:
                couponStatusEnum = CouponStatusEnum.DONE;
//                operatorBalance = operator.getAccount().getBalance();
        }
//        operator.getAccount().setBalance(operatorBalance);
//        saveOperatorState(operator);
        if (order.getStatus() == OrderPayStatus.CONFIRMED) {
            couponService.saveCoupon(CouponService.couponFactoryMethod(order.getRation().getRationName(),
                    couponStatusEnum, order.getAdress(), shippingDate));
            orderService.saveOrder(order);
        } else {
            final Coupon coupon = couponService.getCouponRepository().getByAdressAndShippingDateAndName(
                    order.getAdress(), order.getShippingDate(), order.getRation().getRationName());
            coupon.setCouponStatusEnum(couponStatusEnum);
            couponService.saveCoupon(coupon);
        }
    }

    public static boolean isExtendSubscribe(@NotNull final OrderPayStatus status,
                                            @NotNull final SubscribeStatusEnum subscribe) {
        return subscribe == SubscribeStatusEnum.SUBSCRIBE &&
                (status == OrderPayStatus.PAID || status == OrderPayStatus.CONFIRMED);
    }

    @NotNull
    public Operator getCurrentOperator() {
        return getOperatorByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
