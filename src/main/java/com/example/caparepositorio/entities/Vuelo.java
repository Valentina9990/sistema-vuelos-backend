package com.example.caparepositorio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long idVuelo;
    private LocalDate fechaSalidaVuelo;
    private LocalTime horaSalidaVuelo;
    private Long duracionMinutosVuelo;
    private Long capacidadVuelo;

    @ManyToOne
    @JoinColumn(name = "id_aerolinea", referencedColumnName = "id_aerolinea")
    private Aerolinea aerolinea;

    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_origen", referencedColumnName = "id_aeropuerto")
    private Aeropuerto aeropuertoOrigen;

    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_destino", referencedColumnName = "id_aeropuerto")
    private Aeropuerto aeropuertoDestino;

    @ManyToMany
    @JoinTable(name="rutas",
            joinColumns= @JoinColumn( name="id_vuelo",
                    referencedColumnName="id_vuelo"),
            inverseJoinColumns=@JoinColumn( name="id_reserva",
                    referencedColumnName="id_reserva"))
    private List<Reserva> reservas;

    public Vuelo actualizarCon(Vuelo vuelo) {
        return new Vuelo(
            this.idVuelo,
            vuelo.fechaSalidaVuelo,
            vuelo.horaSalidaVuelo,
            vuelo.duracionMinutosVuelo,
            vuelo.capacidadVuelo,
            vuelo.aerolinea,
            vuelo.aeropuertoOrigen,
            vuelo.aeropuertoDestino,
            vuelo.reservas
        );
    }
}
