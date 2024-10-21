package com.example.vuelos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String direccionCliente;
    private String telefonoCliente;
    private String correoElectronicoCliente;

    @OneToOne(mappedBy = "cliente")
    private Reserva reserva;

    public Cliente actualizarCon(Cliente cliente) {
        return new Cliente(
            this.idCliente,
            cliente.nombreCliente,
            cliente.apellidoCliente,
            cliente.direccionCliente,
            cliente.telefonoCliente,
            cliente.correoElectronicoCliente,
            cliente.reserva
        );
    }
}
