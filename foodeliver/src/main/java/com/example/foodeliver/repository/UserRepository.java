package com.example.foodeliver.repository;

import com.example.foodeliver.entity.person.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName();
}
