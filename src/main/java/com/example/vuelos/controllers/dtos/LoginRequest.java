package com.example.vuelos.controllers.dtos;

import lombok.Data;

public record LoginRequest(
        String username,
        String password) {
}
