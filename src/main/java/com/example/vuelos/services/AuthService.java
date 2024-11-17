package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.JwtResponse;
import com.example.vuelos.entities.User;

public interface AuthService {
    public JwtResponse login(String username, String password);
    public User registerUser(String username, String password, String email);
}
