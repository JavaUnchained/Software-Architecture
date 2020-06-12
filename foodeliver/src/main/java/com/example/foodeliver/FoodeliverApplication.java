package com.example.foodeliver;

import com.example.foodeliver.entity.users.Courier;
import com.example.foodeliver.entity.users.Operator;
import com.example.foodeliver.entity.users.Client;
import com.example.foodeliver.entity.users.Role;
import com.example.foodeliver.repository.CourierRepository;
import com.example.foodeliver.repository.OperatorRepository;
import com.example.foodeliver.repository.ClientRepository;
import com.example.foodeliver.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class FoodeliverApplication implements CommandLineRunner{

    public static void main(String[] args) {

        SpringApplication.run(FoodeliverApplication.class, args);
    }

    @Autowired
    private CourierRepository courierRepository;
    @Autowired
    private OperatorRepository operatorRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Role roleCourier = new Role("ROLE_COURIER");
        roleRepository.save(roleCourier);
        Role roleOperator = new Role("ROLE_OPERATOR");
        roleRepository.save(roleOperator);
        Role roleClient = new Role("ROLE_CLIENT");
        roleRepository.save(roleClient);
        Role roleCook = new Role("ROLE_COOK");
        roleRepository.save(roleCook);

        Courier courier1 =new Courier();
        courier1.setSurname("CourierIvanov");
        courier1.setName("CourierIvan");
        courier1.setPhoneNumber("8-910-111-11-11");
        courier1.setUsername("Courier");
        courier1.setPassword("$2a$10$xDFKjI/oB3/d95NzD7e.Xebe2PzO.2y4Ilbtw34PoOj1jF/ZhHQOi");
        courier1.setRoleId(roleCourier);

        courierRepository.save(courier1);

    }

}
