package com.example.vuelos.dtos;
import java.time.LocalDate;
import java.util.Set;
import java.util.List;

public record ReservaDTO(
        Long idReserva,
        LocalDate fechaReserva,
        Long clienteId,
        Set<Long> pasajerosIds,
        List<Long> vuelosIds
) {}
