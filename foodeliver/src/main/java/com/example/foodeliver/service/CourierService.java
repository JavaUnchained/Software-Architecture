package com.example.foodeliver.service;

import com.example.foodeliver.entity.person.Courier;
import com.example.foodeliver.repository.CourierRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class CourierService {

    @Autowired
    private CourierRepository courierRepository;
    @Autowired
    private ClientService clientService;


    public Courier getCourierByUsername(String username) {
        Courier courier = courierRepository.getDriverByUsername(username);
        return courier;
    }

    public List<Courier> getCouriers() {
        List<Courier> couriers = courierRepository.findAll();
        return couriers;
    }


    public Courier getCourierById(Long idCourier) {
        Courier courier = courierRepository.findById(idCourier).get();
        return courier;
    }

    public void saveCourier(Courier courier) {
        courierRepository.save(courier);
    }

}
