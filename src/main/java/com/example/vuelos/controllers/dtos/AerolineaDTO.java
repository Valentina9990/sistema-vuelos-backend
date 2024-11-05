package com.example.vuelos.controllers.dtos;

public record AerolineaDTO(
        Long idAerolinea,
        String nombreAerolinea,
        String codigoAerolinea,
        String paisOrigenAerolinea
) {}