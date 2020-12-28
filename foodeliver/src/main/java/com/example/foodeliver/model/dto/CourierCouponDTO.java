package com.example.foodeliver.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourierCouponDTO {
    Long id;
    String address;
    String status;
    String shipping;
}
