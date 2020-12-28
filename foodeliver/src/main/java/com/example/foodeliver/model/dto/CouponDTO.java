package com.example.foodeliver.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CouponDTO {
    Long id;
    String address;
    String status;
    String name;
    String shipping;
}
