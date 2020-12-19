package com.example.foodeliver.service;

import com.example.foodeliver.model.entity.Ration;
import com.example.foodeliver.model.repository.RationRepository;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class RationService {
    @Autowired
    RationRepository rationRepository;

    public static Ration getRationOne(final String name, final Double price, final String description){
        return new Ration(name, description, price);
    }

    public void saveRation(@NotNull final Ration ration){
        rationRepository.save(ration);
    }

    public Ration getRationByName(@NotNull final String name){
        return rationRepository.getRationByRationName(name);
    }

    public List<Ration> getAllRations(){
        return rationRepository.findAll();
    }
}
