package com.example.vuelos.controllers.dtos;

public record SignupRequest(String username, String password, String email, String nombreCliente, String apellidoCliente, String direccionCliente, String telefonoCliente, String documentoIdentidad) {
}
