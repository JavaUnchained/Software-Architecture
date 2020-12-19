package com.example.foodeliver.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter @Setter
public class RationDTO {
    final String name;
    final String description;
    final Double price;

    public RationDTO(@NotNull final String name,
                     @NotNull final String description,
                     @NotNull final Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
