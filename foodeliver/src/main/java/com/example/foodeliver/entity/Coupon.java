package com.example.foodeliver.entity;

import com.example.foodeliver.entity.status.CouponStatusEnum;
import com.example.foodeliver.entity.users.Operator;
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

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "operator_id")
//    private Operator operator;

    @Column(name = "c_status")
    @Enumerated(EnumType.STRING)
    CouponStatusEnum couponStatusEnum;

    String name;

    LocalDate shippingDate;


}
