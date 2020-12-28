package com.example.foodeliver.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponseDTO {
    private Long id;
    private String rationName;
    private String date;
    private String status;
    private String subscribed;
    private String fullAddress;
}
