package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.JwtResponse;
import com.example.vuelos.entities.Cliente;
import com.example.vuelos.entities.ERole;
import com.example.vuelos.entities.Role;
import com.example.vuelos.entities.User;
import com.example.vuelos.exceptions.UserAlreadyExistsException;
import com.example.vuelos.repositories.ClienteRepository;
import com.example.vuelos.repositories.RoleRepository;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {
    private final ClienteRepository clienteRepository;
    private final RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, AuthenticationManager authenticationManager, JwtUtil jwtUtil, ClienteRepository clienteRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.clienteRepository = clienteRepository;
        this.roleRepository = roleRepository;
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

    @Transactional
    @Override
    public User registerUser(String username, String password, String email, String nombreCliente, String apellidoCliente, String direccionCliente, String telefonoCliente, String documentoIdentidad) {
        userRepository.findByUsernameOrEmail(username, email).ifPresent(user -> {
            throw new UserAlreadyExistsException("User already exists");
        });

        clienteRepository.findByDocumentoIdentidad(documentoIdentidad).ifPresent(cliente -> {
            throw new UserAlreadyExistsException("Cliente already exists");
        });

        Cliente cliente = new Cliente(null,
                nombreCliente,
                apellidoCliente,
                direccionCliente,
                telefonoCliente,
                documentoIdentidad,
                email,
                new HashSet<>(),
                null);

        Cliente savedCliente = clienteRepository.save(cliente);

        Role role = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        User user = new User(null,
                username,
                passwordEncoder.encode(password),
                email,
                new HashSet<>(List.of(role)),
                savedCliente);

        return userRepository.save(user);
    }

    @Override
    public User me() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
    }
}
