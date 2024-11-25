package com.example.vuelos.controllers.dtos;

import java.time.LocalDate;
import java.util.List;

public record ReservaDTO(
        Long idReserva,
        LocalDate fechaReserva,
        Long clienteId,
        List<PasajeroDTO> pasajeros,
        List<VueloDTO> vuelos
) {}
