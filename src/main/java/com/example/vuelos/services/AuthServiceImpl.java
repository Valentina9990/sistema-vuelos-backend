package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.JwtResponse;
import com.example.vuelos.entities.User;
import com.example.vuelos.exceptions.UserAlreadyExistsException;
import com.example.vuelos.repositories.UserRepository;
import com.example.vuelos.security.services.UserDetailsImpl;
import com.example.vuelos.security.services.jwt.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {
    PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public JwtResponse login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username,
                        password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtUtil.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return new JwtResponse(jwtToken, "Bearer", userDetails.getUsername(), roles);
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
                new HashSet<>(),
                null);

        return userRepository.save(user);
    }
}
