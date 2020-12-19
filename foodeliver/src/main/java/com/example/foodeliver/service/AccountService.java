package com.example.foodeliver.service;

import com.example.foodeliver.model.entity.Account;
import com.example.foodeliver.model.repository.AccountRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    public Account accountFactoryMethod(Double amount) {
        if(amount == null || amount == 0){
            return new Account(0.01d);
        }
        return new Account(amount);
    }
}
