package com.example.foodeliver.model.repository;

import com.example.foodeliver.model.entity.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByName(String name);
}
