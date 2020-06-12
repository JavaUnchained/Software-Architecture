package com.example.foodeliver.repository;

import com.example.foodeliver.entity.users.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role getByName(String name);
}
