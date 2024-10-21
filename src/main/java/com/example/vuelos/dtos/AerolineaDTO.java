package com.example.vuelos.dtos;

public record AerolineaDTO(
        Long idAerolinea,
        String nombreAerolinea,
        String codigoAerolinea,
        String paisOrigenAerolinea
) {}