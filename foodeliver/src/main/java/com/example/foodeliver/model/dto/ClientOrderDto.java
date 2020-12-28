package com.example.foodeliver.model.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ClientOrderDto {
    private Integer rationId;
    private String address;
    private LocalDate shippingDate;
    private Integer subscribed;
}
