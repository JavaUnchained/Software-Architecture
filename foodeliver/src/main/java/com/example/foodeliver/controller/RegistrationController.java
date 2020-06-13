package com.example.foodeliver.controller;

import com.example.foodeliver.entity.Account;
import com.example.foodeliver.entity.users.Client;
import com.example.foodeliver.entity.users.Role;
import com.example.foodeliver.service.AccountService;
import com.example.foodeliver.service.CourierService;
import com.example.foodeliver.service.ClientService;
import com.example.foodeliver.service.RoleService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Getter
@Setter
public class RegistrationController {
//@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
    @Autowired
    private ClientService clientService;

    @Autowired
    private CourierService courierService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String username, @RequestParam String password,
                               @RequestParam String name, @RequestParam String surname,
                               @RequestParam String phoneNumber, @RequestParam Integer account) {

        Double balance = account.doubleValue();
        Account account1 = accountService.accountFactoryMethod(balance);

        Client client = new Client();
        client.setSurname(surname);
        client.setName(name);
        client.setPhoneNumber(phoneNumber);
        client.setUsername(username);
        client.setAccount(account1);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        client.setPassword(encoder.encode(password));
        Role role = roleService.getRoleByName("ROLE_CLIENT");
        client.setRoleId(role);

        clientService.saveClient(client);

        return "redirect:/index";
    }

}
