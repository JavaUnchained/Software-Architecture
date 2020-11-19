package com.example.foodeliver.entity;

import com.example.foodeliver.entity.status.OrderPayStatus;
import com.example.foodeliver.entity.status.SubscrabeStatusEnum;
import com.example.foodeliver.entity.users.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

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

    @Column(name = "o_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderPayStatus status;

    @Column(name = "shipping_date", nullable = false)
    private LocalDate shippingDate;

    @Column(name = "subsribe", nullable = false)
    @Enumerated(EnumType.STRING)
    private SubscrabeStatusEnum subscrabeStatusEnum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ration_id")
    private Ration ration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id")
    private Adress adress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    public Order(@NotNull final OrderPayStatus status, @NotNull final Adress adress,
                 @NotNull final LocalDate shippingDate, @NotNull final SubscrabeStatusEnum subscrabeStatusEnum,
                 @NotNull final Ration ration) {
        this.status = status;
        this.adress = adress;
        this.shippingDate = shippingDate;
        this.subscrabeStatusEnum = subscrabeStatusEnum;
        this.ration = ration;
    }
}
