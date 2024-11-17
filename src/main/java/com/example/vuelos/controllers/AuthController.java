package com.example.vuelos.controllers;

import com.example.vuelos.controllers.dtos.JwtResponse;
import com.example.vuelos.controllers.dtos.LoginRequest;
import com.example.vuelos.controllers.dtos.SignupRequest;
import com.example.vuelos.entities.User;
import com.example.vuelos.repositories.UserRepository;
import com.example.vuelos.security.services.UserDetailsImpl;
import com.example.vuelos.security.services.jwt.JwtUtil;
import com.example.vuelos.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    UserRepository userRepository;
    private final AuthService authService;

    public AuthController(PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserRepository userRepository, AuthService authService) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(),
                        loginRequest.password())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtUtil.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwtToken, "Bearer", userDetails.getUsername(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody SignupRequest signupRequest) {
        User newUser = authService.registerUser(signupRequest.username(), signupRequest.password(), signupRequest.email());
        return ResponseEntity.ok(newUser);
    }
}
