package com.example.foodeliver.controller;

import com.example.foodeliver.model.dto.UserRegistrationDTO;
import com.example.foodeliver.service.RegistrationService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(path = "/registration", method = {RequestMethod.GET,RequestMethod.POST} )
    public ResponseEntity<?> registration(@RequestBody @NotNull final UserRegistrationDTO reg) {
        if(List.of(reg.getUsername(), reg.getPassword(), reg.getName(), reg.getSurname(),
                reg.getPhoneNumber(), reg.getAccount()).stream().anyMatch(Objects::isNull)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        registrationService.registrationNewUser(reg.getUsername(), reg.getPassword(),
                reg.getName(), reg.getSurname(), reg.getPhoneNumber(), reg.getAccount());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
