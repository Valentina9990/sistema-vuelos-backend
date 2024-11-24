package com.example.vuelos.controllers.dtos;

import com.example.vuelos.entities.Aerolinea;
import com.example.vuelos.entities.Pasajero;
import com.example.vuelos.entities.Reserva;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record VueloDTO(
        Long idVuelo,
        LocalDate fechaSalidaVuelo,
        LocalTime horaSalidaVuelo,
        Long duracionMinutosVuelo,
        Long capacidadVuelo,
        Long aerolineaId,
        Long aeropuertoOrigenId,
        Long aeropuertoDestinoId,
        List<Long> reservasIds
) {}
