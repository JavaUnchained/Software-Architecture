package com.example.foodeliver.controller;

import com.example.foodeliver.model.dto.UserRegistrationDTO;
import com.example.foodeliver.service.RegistrationService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody @NotNull final UserRegistrationDTO reg) {
        if(!reg.isAllFieldsNonNull()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        registrationService.registrationNewUser(reg.getUsername(), reg.getPassword(),
                reg.getName(), reg.getSurname(), reg.getPhoneNumber(), reg.getAccount());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
