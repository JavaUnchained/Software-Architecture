package com.example.foodeliver.service;

import com.example.foodeliver.model.entity.users.User;
import com.example.foodeliver.model.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetailService implements UserDetailsService {

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
