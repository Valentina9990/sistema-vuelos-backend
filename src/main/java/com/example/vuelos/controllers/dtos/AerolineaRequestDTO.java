package com.example.vuelos.controllers.dtos;

public record AerolineaRequestDTO(
        String nombreAerolinea,
        String codigoAerolinea,
        String paisOrigenAerolinea
) { }
