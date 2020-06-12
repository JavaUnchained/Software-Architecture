package com.example.foodeliver.controller;

import com.example.foodeliver.entity.person.Client;
import com.example.foodeliver.entity.person.Role;
import com.example.foodeliver.service.DriverService;
import com.example.foodeliver.service.PassengerService;
import com.example.foodeliver.service.RoleService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@Getter
@Setter
public class RegistrationController {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String surname, @RequestParam String name, @RequestParam String phoneNumber,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
                               @RequestParam String username, @RequestParam String password, @RequestParam String bankcardNumber) {
        Client client = new Client();
        client.setSurname(surname);
        client.setName(name);
        client.setPhoneNumber(phoneNumber);
        client.setDateOfBirth(dateOfBirth);
        client.setUsername(username);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        client.setPassword(encoder.encode(password));
        Role role = roleService.getRoleByName("ROLE_PASSENGER");
        client.setRoleId(role);

        passengerService.savePassenger(client);
        return "redirect:/clientpage";
    }

}
