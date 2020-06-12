package com.example.foodeliver.repository;

import com.example.foodeliver.entity.person.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User getUserByUsername(String username);
}
