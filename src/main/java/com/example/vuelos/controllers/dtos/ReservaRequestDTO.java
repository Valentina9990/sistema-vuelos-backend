package com.example.vuelos.controllers.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record ReservaRequestDTO (
        LocalDate fechaReserva,
        Long clienteId
) { }
