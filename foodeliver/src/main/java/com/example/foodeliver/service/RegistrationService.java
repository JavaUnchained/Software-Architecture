package com.example.foodeliver.service;

import com.example.foodeliver.model.entity.Account;
import com.example.foodeliver.model.entity.users.Role;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
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

        final Account account1 = accountService.accountFactoryMethod(account);
//        final PasswordEncoder encoder = new BCryptPasswordEncoder();
//        final String encodedPassword = encoder.encode(password);
        final Role role = roleService.getRoleByName("ROLE_CLIENT");
//        final Client client = new Client(surname,name,phoneNumber,username,encodedPassword,role,account1);
//        clientService.saveClient(client);
    }
}
