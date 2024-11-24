package com.example.vuelos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "reserva")
    private Set<Pasajero> pasajeros;

    @JsonIgnore
    @OneToOne(optional = false)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @JsonIgnore
    @ManyToMany(mappedBy = "reservas")
    private List<Vuelo> vuelos;
}
