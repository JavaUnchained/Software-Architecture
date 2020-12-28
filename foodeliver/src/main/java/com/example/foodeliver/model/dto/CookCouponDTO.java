package com.example.foodeliver.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CookCouponDTO {
    Long id;
    String name;
    String shipping;
}
