package com.example.foodeliver.model.repository;

import com.example.foodeliver.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
