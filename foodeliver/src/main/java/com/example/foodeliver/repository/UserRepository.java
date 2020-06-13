package com.example.foodeliver.repository;

import com.example.foodeliver.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
}
