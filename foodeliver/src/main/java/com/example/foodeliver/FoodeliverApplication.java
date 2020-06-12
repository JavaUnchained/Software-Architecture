package com.example.foodeliver;

import com.example.foodeliver.entity.person.Courier;
import com.example.foodeliver.entity.person.Operator;
import com.example.foodeliver.entity.person.Client;
import com.example.foodeliver.entity.person.Role;
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
        Role roleDriver = new Role("ROLE_DRIVER");
        roleRepository.save(roleDriver);
        Role roleOperator = new Role("ROLE_OPERATOR");
        roleRepository.save(roleOperator);
        Role rolePassenger = new Role("ROLE_PASSENGER");
        roleRepository.save(rolePassenger);

        Courier courier1 =new Courier();
        courier1.setSurname("Driver1Surname");
        courier1.setName("Driver1Name");
        courier1.setDateOfBirth(LocalDate.of(1960,10,5));
        courier1.setPhoneNumber("8-910-100-00-00");
        courier1.setUsername("d1");
        courier1.setPassword("$2a$10$xDFKjI/oB3/d95NzD7e.Xebe2PzO.2y4Ilbtw34PoOj1jF/ZhHQOi");
        courier1.setRoleId(roleDriver);

        courierRepository.save(courier1);


        Courier courier2 =new Courier();
        courier2.setSurname("Driver2Surname");
        courier2.setName("Driver2Name");
        courier2.setDateOfBirth(LocalDate.of(1987,10,13));
        courier2.setPhoneNumber("8-910-200-20-00");
        courier2.setUsername("d2");
        courier2.setPassword("$2a$10$c.CRBiZJVWFOxPQy2PwCuOr8IwlRHF8IVkRqdUazABxwvAR2spU5m");
        courier2.setRoleId(roleDriver);

        courierRepository.save(courier2);





        Operator operator1 = new Operator();
        operator1.setSurname("Operator1Surname");
        operator1.setName("Operator1Name");
        operator1.setDateOfBirth(LocalDate.of(1989,12,10));
        operator1.setPhoneNumber("8-950-123-11-11");
        operator1.setUsername("o1");
        operator1.setPassword("123123123");
        operator1.setRoleId(roleOperator);
        operatorRepository.save(operator1);


        Operator operator2 = new Operator();
        operator2.setUsername("Operator3Surname");
        operator2.setName("Operator3Name");
        operator2.setDateOfBirth(LocalDate.of(1990,5,7));
        operator2.setPhoneNumber("8-950-852-78-88");
        operator2.setUsername("o4");
        operator2.setPassword("123123123");
        operator2.setRoleId(roleRepository.getByName("ROLE_OPERATOR"));
        operatorRepository.save(operator2);


        Client client1 =new Client();
        client1.setSurname("Passenger1Surname");
        client1.setName("Passenger1Name");
        client1.setDateOfBirth(LocalDate.of(1979,11,3));
        client1.setPhoneNumber("8-980-111-22-25");
        client1.setUsername("p1");
        client1.setPassword("$2a$10$8SMwIL8PL2w4zuqz8phx9.rkj.AP1913AOJVgNf9zhQo1bZxVxXci");
        client1.setRoleId(rolePassenger);
        clientRepository.save(client1);


        Client client2 =new Client();
        client2.setSurname("Passenger2Surname");
        client2.setName("Passenger2Name");
        client2.setDateOfBirth(LocalDate.of(1984,5,10));
        client2.setPhoneNumber("8-980-251-80-80");
        client2.setUsername("p2");
        client2.setPassword("$2a$10$f5FjBoebekM9HYuFjgn5NeX9GUyd5VoD7wL5ZgJG.M6/NO6lk3bfu");
        client2.setRoleId(rolePassenger);
        clientRepository.save(client2);

    }

}
