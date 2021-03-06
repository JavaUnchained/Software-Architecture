package com.example.foodeliver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ration")
@Getter @Setter
@NoArgsConstructor
public class Ration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ration_name", unique = true, nullable = false)
    private String rationName;
    private String rationDescription;
    private Double price;

    @OneToOne(mappedBy = "ration", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    })
    private Order order;

    public Ration(String rationName, String rationDescription, Double price) {
        this.rationName = rationName;
        this.rationDescription = rationDescription;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ration:" +
                rationName + '\'' +
                rationDescription + '\'' + price;
    }
}
