package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.JwtResponse;
import com.example.vuelos.entities.User;
import com.example.vuelos.exceptions.UserAlreadyExistsException;
import com.example.vuelos.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class AuthServiceImpl implements AuthService {
    PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public JwtResponse login(String username, String password) {
        return null;
    }

    @Override
    public User registerUser(String username, String password, String email) {
        userRepository.findByUsernameOrEmail(username, email).ifPresent(user -> {
            throw new UserAlreadyExistsException("User already exists");
        });

        User user = new User(null,
                username,
                passwordEncoder.encode(password),
                email,
                new HashSet<>());

        return userRepository.save(user);
    }
}
