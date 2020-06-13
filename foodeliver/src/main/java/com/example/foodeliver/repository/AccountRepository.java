package com.example.foodeliver.repository;

import com.example.foodeliver.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
