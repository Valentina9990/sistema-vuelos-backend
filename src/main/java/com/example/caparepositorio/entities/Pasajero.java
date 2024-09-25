package com.example.caparepositorio.entities;

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
    private Integer documentoIdentidadPasajero;

    @ManyToOne
    @JoinColumn(name = "idReserva")
    private Reserva reserva;

    public Pasajero actualizarCon(Pasajero pasajero) {
        return new Pasajero(
            this.idPasajero,
            pasajero.nombrePasajero,
            pasajero.apellidoPasajero,
            pasajero.documentoIdentidadPasajero,
            pasajero.reserva
        );
    }
}
