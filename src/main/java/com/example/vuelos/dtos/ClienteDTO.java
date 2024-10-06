package com.example.vuelos.dtos;

public record ClienteDTO (
    Long idCliente,
    String nombreCliente,
    String apellidoCliente,
    String direccionCliente,
    String telefonoCliente,
    String correoElectronicoCliente
){}
