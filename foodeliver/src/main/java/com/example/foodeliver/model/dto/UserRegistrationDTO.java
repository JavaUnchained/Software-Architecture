package com.example.foodeliver.model.dto;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class UserRegistrationDTO {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private Double account;

    public boolean isAllFieldsNonNull() {
        return List.of(username, password, name, surname, phoneNumber, account).stream().noneMatch(Objects::isNull);
    }
}
