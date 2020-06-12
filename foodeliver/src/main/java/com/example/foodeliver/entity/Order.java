package com.example.foodeliver.entity;

import com.example.foodeliver.entity.status.OrderPayStatus;
import com.example.foodeliver.entity.status.SubscrabeStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "order")
@Getter @Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "status", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private OrderPayStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ration_id")
    private Ration ration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id")
    private Adress adress;

    @Column(name = "shipping_date")
    private LocalDate shippingDate;

    @Column(name = "subsribe", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private SubscrabeStatusEnum subscrabeStatusEnum;

    public Order(OrderPayStatus status,Ration ration,Adress adress,
                 LocalDate shippingDate, SubscrabeStatusEnum subscrabeStatusEnum ) {
        this.status = status;
        this.ration = ration;
        this.adress = adress;
        this.shippingDate = shippingDate;
        this.subscrabeStatusEnum = subscrabeStatusEnum;
    }
}
