package com.example.foodeliver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Ration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rationName;
    private String rationDescription;
    private Double price;

    public Ration(String rationName, String rationDescription, Double price) {
        this.rationName = rationName;
        this.rationDescription = rationDescription;
        this.price = price;
    }
}
