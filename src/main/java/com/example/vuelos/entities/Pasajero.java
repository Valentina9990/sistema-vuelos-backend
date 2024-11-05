package com.example.vuelos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pasajeros")

public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPasajero;
    private String nombrePasajero;
    private String apellidoPasajero;
    @Column(unique = true)
    private String documentoIdentidadPasajero;

    @ManyToOne
    @JoinColumn(name = "idReserva")
    private Reserva reserva;
}
