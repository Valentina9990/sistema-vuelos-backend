package com.example.vuelos.controllers.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.vuelos.entities.Aerolinea;
import com.example.vuelos.entities.Aeropuerto;

public record VueloClientDTO(Long idVuelo, LocalDate fechaSalidaVuelo, LocalTime horaSalidaVuelo,
                             Long duracionMinutosVuelo, Long capacidadVuelo, Aerolinea aerolinea,
                             Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, Long countPasajeros,
                             Long countReservas) { }
