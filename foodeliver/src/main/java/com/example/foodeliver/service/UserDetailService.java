package com.example.foodeliver.service;

import com.example.foodeliver.entity.users.User;
import com.example.foodeliver.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @NotNull
    public UserDetails loadUserByUsername(final String s) throws UsernameNotFoundException {
        final User user = userRepository.getUserByUsername(s);
        if (user == null) throw new UsernameNotFoundException("Could not find user");
        return new UserDetail(user);
    }
}
