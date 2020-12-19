package com.example.foodeliver.service;

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
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Getter
@Setter
public class OperatorService {
    public static final int ADD_MONTH = 30;
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
        final Double operatorBalance;
        final CouponStatusEnum couponStatusEnum;
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
            default:
                couponStatusEnum = CouponStatusEnum.DONE;
//                operatorBalance = operator.getAccount().getBalance();
        }
        final LocalDate shippingDate = order.getShippingDate();
        if(isExtendSubscribe(order.getStatus(), order.getSubscrabeStatusEnum())) {
            order.setShippingDate(shippingDate.plusDays(ADD_MONTH));
            order.setStatus(OrderPayStatus.PAID);
        }
//        operator.getAccount().setBalance(operatorBalance);
//        saveOperatorState(operator);
        orderService.saveOrder(order);
        couponService.saveCoupon(CouponService.couponFactoryMethod(order.getRation().getRationName(),
                couponStatusEnum, order.getAdress(), shippingDate));
    }

    public static boolean isExtendSubscribe(@NotNull final OrderPayStatus status,
                                            @NotNull final SubscribeStatusEnum subscribe) {
        return subscribe == SubscribeStatusEnum.SUBSCRIBE &&
                (status == OrderPayStatus.PAID || status == OrderPayStatus.CONFIRMED);
    }

//    @NotNull
//    public Operator getCurrentOperator() {
//        return getOperatorByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
//    }
}
