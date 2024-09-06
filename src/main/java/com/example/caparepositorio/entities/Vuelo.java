package com.example.caparepositorio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "vuelos")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Vuelo {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id_vuelo;
    private LocalDate fecha_salida_vuelo;
    private LocalTime hora_salida_vuelo;
    private Long duracion_minutos_vuelo;
    private Long capacidad_vuelo;

    @ManyToOne
    @JoinColumn(name = "id_aerolinea", referencedColumnName = "id_aerolinea")
    private Aerolinea aerolinea;

    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_origen", referencedColumnName = "id_aeropuerto")
    private Aeropuerto aeropuerto_origen;

    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_destino", referencedColumnName = "id_aeropuerto")
    private Aeropuerto aeropuerto_destino;

    @ManyToMany
    @JoinTable(name="rutas",
            joinColumns= @JoinColumn( name="id_vuelo",
                    referencedColumnName="id_vuelo"),
            inverseJoinColumns=@JoinColumn( name="id_reserva",
                    referencedColumnName="id_reserva"))
    private List<Reserva> reservas;
}
