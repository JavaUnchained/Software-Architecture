package com.example.foodeliver.model.dto;

import lombok.Data;

@Data
public class Ration {
    final Long id;
    final String name;
    final String description;
    final Double price;
}
