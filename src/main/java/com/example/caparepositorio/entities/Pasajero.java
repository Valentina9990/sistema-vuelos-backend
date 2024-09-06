package com.example.caparepositorio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pasajeros")

public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pasajero;
    private String nombre_pasajero;
    private String apellido_pasajero;
    private Integer documento_identidad_pasajero;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
}
