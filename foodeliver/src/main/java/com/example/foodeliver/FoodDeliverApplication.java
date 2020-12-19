package com.example.foodeliver;

import com.example.foodeliver.repository.ClientRepository;
import com.example.foodeliver.repository.CourierRepository;
import com.example.foodeliver.repository.OperatorRepository;
import com.example.foodeliver.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodDeliverApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodDeliverApplication.class, args);
    }
}
