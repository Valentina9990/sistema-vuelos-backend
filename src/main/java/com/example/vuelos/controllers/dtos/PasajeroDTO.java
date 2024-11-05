package com.example.vuelos.controllers.dtos;

public record PasajeroDTO(
        Long idPasajero,
        String nombrePasajero,
        String apellidoPasajero,
        String documentoIdentidadPasajero,
        Long reservaId
) {}
