package com.example.foodeliver.entity;

import com.example.foodeliver.entity.status.CouponStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "coupon")
@Getter @Setter
@NoArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id")
    private Adress adress;

    public Coupon(String name, CouponStatusEnum couponStatusEnum, Adress adress, LocalDate shippingDate) {
        this.adress = adress;
        this.couponStatusEnum = couponStatusEnum;
        this.name = name;
        this.shippingDate = shippingDate;
    }

    //    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "operator_id")
//    private Operator operator;

    @Column(name = "c_status")
    @Enumerated(EnumType.STRING)
    CouponStatusEnum couponStatusEnum;

    String name;

    LocalDate shippingDate;


}
