package com.example.foodeliver.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "adress")
@Getter
@Setter
@NoArgsConstructor
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(mappedBy = "adress", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    })
    private Order order;

    private String city;
    private String street;
    private String house;
    private String flat;

    public Adress(String city, String street, String house, String flat) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }
}
