package com.example.vuelos.controllers.dtos;

public record ClienteDTO (
    Long idCliente,
    String nombreCliente,
    String apellidoCliente,
    String direccionCliente,
    String telefonoCliente,
    String documentoIdentidad,
    String correoElectronicoCliente
){}
