package com.example.foodeliver.service;

import com.example.foodeliver.domain.users.Operator;
import com.example.foodeliver.repository.CouponRepository;
import com.example.foodeliver.repository.OperatorRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private CouponRepository couponRepository;

    public Operator getOperatorByUsername(String username) {
        Operator operator = operatorRepository.getOperatorByUsername(username);
        return operator;
    }


    public void saveOperatorState(Operator operator) {
        operatorRepository.save(operator);
    }

}
