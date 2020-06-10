package com.example.foodeliver.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ADRESS")
@Data
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String street;
    private String flat;
}
