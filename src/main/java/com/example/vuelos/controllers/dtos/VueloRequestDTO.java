package com.example.vuelos.controllers.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record VueloRequestDTO(
        LocalDate fechaSalidaVuelo,
        LocalTime horaSalidaVuelo,
        Long duracionMinutosVuelo,
        Float precioVuelo,
        Long capacidadVuelo,
        Long aerolineaId,
        Long aeropuertoOrigenId,
        Long aeropuertoDestinoId
) { }
