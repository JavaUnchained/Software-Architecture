package com.example.foodeliver.model.dto;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class RationDTO {
    final String name;
    final String description;
    final Double price;

    public boolean isAllFieldNonNull() {
        return List.of(name, description, price).stream().noneMatch(Objects::isNull);
    }
}
