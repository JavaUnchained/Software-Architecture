package com.example.foodeliver.service;

import com.example.foodeliver.entity.users.User;
import com.sun.tools.javac.util.List;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public class UserDetail implements UserDetails {

    private final User user;

    public UserDetail(@NotNull final User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of((new SimpleGrantedAuthority(user.getRoleId().getName())));
    }

    @Override
    @NotNull
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    @NotNull
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
