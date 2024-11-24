package com.example.vuelos.controllers;

import com.example.vuelos.controllers.dtos.JwtResponse;
import com.example.vuelos.controllers.dtos.LoginRequest;
import com.example.vuelos.controllers.dtos.SignupRequest;
import com.example.vuelos.entities.User;
import com.example.vuelos.repositories.UserRepository;
import com.example.vuelos.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    private final AuthService authService;

    public AuthController(PasswordEncoder passwordEncoder, UserRepository userRepository, AuthService authService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest.username(), loginRequest.password()));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody SignupRequest signupRequest) {
        User newUser = authService.registerUser(signupRequest.username(), signupRequest.password(), signupRequest.email());
        return ResponseEntity.ok(newUser);
    }
}
