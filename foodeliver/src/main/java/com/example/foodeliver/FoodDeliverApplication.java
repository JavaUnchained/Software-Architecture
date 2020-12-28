package com.example.foodeliver;

import com.example.foodeliver.model.entity.Account;
import com.example.foodeliver.model.entity.Ration;
import com.example.foodeliver.model.entity.users.*;
import com.example.foodeliver.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodDeliverApplication implements CommandLineRunner {

    @Autowired
    private CourierRepository courierRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CookRepository cookRepository;
    @Autowired
    private OperatorRepository operatorRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RationRepository rationRepository;

    public static void main(final String[] args) {
        SpringApplication.run(FoodDeliverApplication.class, args);
    }

    @Override
    public void run(final String... args) {
        final Role roleClient = new Role("ROLE_CLIENT");
        final Role roleCook = new Role("ROLE_COOK");
        final Role roleCourier = new Role("ROLE_COURIER");
        final Role roleOperator = new Role("ROLE_OPERATOR");

        final Client client = new Client("Ivaonv", "Ivan", "8-800-555-35-35",
                "Client1", "$2a$10$HJ0zdmeVHJwvU0WaroXOeey717UMGMR/cDR8pb1Bh3/BJT/1kw8he",
                roleClient, new Account(1000d));
        final Operator operator = new Operator("Petr", "Petrovich", "8-999-812-99-88",
                "Operator1", "$2a$10$HJ0zdmeVHJwvU0WaroXOeey717UMGMR/cDR8pb1Bh3/BJT/1kw8he",
                roleOperator, new Account(1000d));
        final Courier courier = new Courier("Sidor", "Sidorov", "8-999-999-99-99",
                "Delivery1", "$2a$10$HJ0zdmeVHJwvU0WaroXOeey717UMGMR/cDR8pb1Bh3/BJT/1kw8he", roleCourier);
        final Cook cook = new Cook("Loren", "Ipsumov", "8-888-888-88-88", "Povar1",
                "$2a$10$HJ0zdmeVHJwvU0WaroXOeey717UMGMR/cDR8pb1Bh3/BJT/1kw8he", roleCook);
        final Ration ration1 = new Ration("Спортивный", "Правильное питание", 200d);
        final Ration ration2 = new Ration("Обжора", "Супер калорийный", 400d);
        final Ration ration3 = new Ration("Бюджетный", "Для тех кто экономит", 50d);

        roleRepository.save(roleClient);
        roleRepository.save(roleCourier);
        roleRepository.save(roleOperator);
        roleRepository.save(roleCook);

        clientRepository.save(client);
        operatorRepository.save(operator);
        courierRepository.save(courier);
        cookRepository.save(cook);

        rationRepository.save(ration1);
        rationRepository.save(ration2);
        rationRepository.save(ration3);
    }
}
