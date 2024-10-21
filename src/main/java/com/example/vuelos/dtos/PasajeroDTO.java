package com.example.vuelos.dtos;

public record PasajeroDTO(
        Long idPasajero,
        String nombrePasajero,
        String apellidoPasajero,
        Integer documentoIdentidadPasajero,
        Long reservaId
) {}
