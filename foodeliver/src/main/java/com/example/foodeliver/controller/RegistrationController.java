package com.example.foodeliver.controller;

import com.example.foodeliver.service.RegistrationService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.util.Objects.isNull;

@Controller
@Getter
@Setter
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam final String username, @RequestParam final String password,
                               @RequestParam final String name, @RequestParam final String surname,
                               @RequestParam final String phoneNumber, @RequestParam final Double account) {
        if (isNull(username) || isNull(password) || isNull(name) || isNull(surname)
                || isNull(phoneNumber) || isNull(account) || account >= 0){
            throw new IllegalArgumentException("Invalid arguments");
        }
        registrationService.registrationNewUser(username, password, name, surname, phoneNumber, account);
        return "redirect:/";
    }
}
