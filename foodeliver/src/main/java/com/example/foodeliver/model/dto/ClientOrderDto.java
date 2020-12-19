package com.example.foodeliver.model.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Data
public class ClientOrderDto {
    private String name;
    private String address;
    private LocalDate stripping;
    private Integer subscribed;

    public boolean isAllFieldNonNull() {
        return List.of(name, address, stripping, subscribed).stream().noneMatch(Objects::isNull);
    }

}
