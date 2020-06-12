package com.example.foodeliver.service;

import com.example.foodeliver.entity.users.Role;
import com.example.foodeliver.repository.RoleRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleByName(String name) {
        Role role = roleRepository.getByName(name);
        return role;
    }

}
