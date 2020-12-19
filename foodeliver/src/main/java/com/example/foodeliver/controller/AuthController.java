package com.example.foodeliver.controller;

import com.example.foodeliver.auth.AuthRequest;
import com.example.foodeliver.auth.AuthResponse;
import com.example.foodeliver.entity.users.User;
import com.example.foodeliver.repository.UserRepository;
import com.example.foodeliver.service.JWT.JwtUtil;
import com.example.foodeliver.service.UserDetail;
import com.example.foodeliver.service.UserDetailService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private UserDetailsService detailService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody @NotNull final AuthRequest req) throws Exception {
        final UserDetails details;
        final String username = req.getUsername();
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, req.getPassword()));
            details = detailService.loadUserByUsername(req.getUsername());
        } catch (final BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        } catch (final UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        String jwt = JwtUtil.generateToken(details);
        final User user = userRepository.getUserByUsername(username);
        final String role = user.getRoleId().getName();
        final Long id = user.getId();
        return ResponseEntity.ok(new AuthResponse(jwt, role, id));
    }
}
