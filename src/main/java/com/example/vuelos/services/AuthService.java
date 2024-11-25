package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.JwtResponse;
import com.example.vuelos.entities.User;

public interface AuthService {
    JwtResponse login(String username, String password);
    User registerUser(String username, String password, String email);
    User me();
}
