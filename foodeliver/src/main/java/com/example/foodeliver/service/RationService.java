package com.example.foodeliver.service;

import com.example.foodeliver.entity.Ration;
import com.example.foodeliver.repository.RationRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class RationService {
    @Autowired
    RationRepository rationRepository;

    public Ration rationFactoryMethod(String name,Double price, String description){
        return new Ration(name, description, price);
    }

    public void saveRation(Ration ration){
        rationRepository.save(ration);
    }

    public Ration getRationByName(String name){
        return rationRepository.getRationByRationName(name);
    }

    public List<Ration> getAllRations(){
        return rationRepository.findAll();
    }
}
