package com.example.foodeliver.service;

import com.example.foodeliver.model.entity.users.Client;
import com.example.foodeliver.model.entity.users.Role;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private ClientService clientService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AccountService accountService;

    public  void registrationNewUser(@NotNull final String username, @NotNull final String password,
                                     @NotNull final String name, @NotNull final String surname,
                                     @NotNull final String phoneNumber, @NotNull final Double account) {
        final String encodedPassword = new BCryptPasswordEncoder().encode(password);
        final Role role = roleService.getRoleByName("ROLE_CLIENT");
        final Client client = new Client(surname,name,phoneNumber,username,
                encodedPassword,role, AccountService.accountFactoryMethod(account));
        clientService.saveClient(client);
    }
}
