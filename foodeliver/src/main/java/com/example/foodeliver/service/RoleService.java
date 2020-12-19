package com.example.foodeliver.service;

import com.example.foodeliver.model.entity.users.Role;
import com.example.foodeliver.model.repository.RoleRepository;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @NotNull
    public Role getRoleByName(final String name) {
        return roleRepository.getRoleByName(name);
    }

}
