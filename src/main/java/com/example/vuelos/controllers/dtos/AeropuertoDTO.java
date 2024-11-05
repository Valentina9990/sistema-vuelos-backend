package com.example.vuelos.controllers.dtos;

public record AeropuertoDTO(
        Long idAeropuerto,
        String nombreAeropuerto,
        String ciudadAeropuerto,
        String paisAeropuerto
) {}
