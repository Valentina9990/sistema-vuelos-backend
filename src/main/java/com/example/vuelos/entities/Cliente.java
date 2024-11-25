package com.example.vuelos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private Set<Reserva> reservas;

    @JsonIgnore
    @OneToOne(mappedBy = "cliente")
    private User user;
}
