package com.example.foodeliver.controller;

import com.example.foodeliver.entity.users.Client;
import com.example.foodeliver.entity.users.Role;
import com.example.foodeliver.service.CourierService;
import com.example.foodeliver.service.ClientService;
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
    private ClientService clientService;

    @Autowired
    private CourierService courierService;

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

        clientService.savePassenger(client);
        return "redirect:/clientpage";
    }

}
