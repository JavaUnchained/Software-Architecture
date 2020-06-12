package com.example.foodeliver.repository;

import com.example.foodeliver.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User getUserByUsername(String username);
}
