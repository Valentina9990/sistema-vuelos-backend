package com.example.vuelos.controllers.dtos;

public record PasajeroRequestDTO(
        String nombrePasajero,
        String apellidoPasajero,
        String documentoIdentidadPasajero,
        Long reservaId
) { }
