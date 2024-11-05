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
    @Column(unique = true)
    private String documentoIdentidad;
    private String correoElectronicoCliente;

    @OneToOne(mappedBy = "cliente")
    private Reserva reserva;
}
