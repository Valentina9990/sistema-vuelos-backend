package com.example.vuelos.controllers.dtos;

public record ClienteRequestDTO(
        String nombreCliente,
        String apellidoCliente,
        String direccionCliente,
        String telefonoCliente,
        String documentoIdentidad,
        String correoElectronicoCliente
){}
