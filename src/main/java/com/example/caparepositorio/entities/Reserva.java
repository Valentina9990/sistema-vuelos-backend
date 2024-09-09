package com.example.caparepositorio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "reservas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;
    private LocalDate fechaReserva;

    @OneToMany(mappedBy = "reserva")
    private Set<Pasajero> pasajeros;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @ManyToMany(mappedBy = "reservas")
    private List<Vuelo> vuelos;

    public Reserva actualizarCon(Reserva reserva) {
        return new Reserva(
            this.idReserva,
            reserva.fechaReserva,
            reserva.pasajeros,
            reserva.cliente,
            reserva.vuelos
        );
    }
}
