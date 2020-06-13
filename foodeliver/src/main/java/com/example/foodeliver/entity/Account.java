package com.example.foodeliver.entity;

import com.example.foodeliver.entity.users.Client;
import com.example.foodeliver.entity.users.Operator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Getter @Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "balance", nullable = false)
    private Double balance;

    public Account(Double balance) {
        this.balance = balance;
    }

    @OneToOne(mappedBy = "account", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    })
    private Client passenger;

    @OneToOne(mappedBy = "account", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    })
    private Operator driver;
}
