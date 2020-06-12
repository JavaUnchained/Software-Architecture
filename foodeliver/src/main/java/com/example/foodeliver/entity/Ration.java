package com.example.foodeliver.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Ration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ration_name", unique = true, nullable = false)
    private String rationName;
    private String rationDescription;
    private Double price;

    public Ration(String rationName, String rationDescription, Double price) {
        this.rationName = rationName;
        this.rationDescription = rationDescription;
        this.price = price;
    }
}
