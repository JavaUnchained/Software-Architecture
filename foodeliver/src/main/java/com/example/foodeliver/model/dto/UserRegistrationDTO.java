package com.example.foodeliver.model.dto;

import lombok.Data;

@Data
public class UserRegistrationDTO {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private Double account;
}
