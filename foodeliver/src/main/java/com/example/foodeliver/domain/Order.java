package com.example.foodeliver.domain;

import com.example.foodeliver.domain.status.OrderPayStatus;
import com.example.foodeliver.domain.status.SubscrabeStatusEnum;
import com.example.foodeliver.domain.users.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ord")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "o_status")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    public Order(OrderPayStatus status,Adress adress,
                 LocalDate shippingDate, SubscrabeStatusEnum subscrabeStatusEnum, Ration ration) {
        this.status = status;
        this.adress = adress;
        this.shippingDate = shippingDate;
        this.subscrabeStatusEnum = subscrabeStatusEnum;
        this.ration = ration;
    }
}
