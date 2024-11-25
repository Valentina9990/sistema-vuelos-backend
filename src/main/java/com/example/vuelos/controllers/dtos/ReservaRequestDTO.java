package com.example.vuelos.controllers.dtos;

import java.util.List;

public record ReservaRequestDTO (
        Long idCliente,
        Long idVuelo,
        List<PasajeroRequestDTO> pasajeros
) { }
