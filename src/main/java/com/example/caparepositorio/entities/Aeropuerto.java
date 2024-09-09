package com.example.caparepositorio.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "aeropuertos")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Aeropuerto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAeropuerto;
    private String nombreAeropuerto;
    private String ciudadAeropuerto;
    private String paisAeropuerto;

    public Aeropuerto actualizarCon(Aeropuerto aeropuerto) {
        return new Aeropuerto(
            this.idAeropuerto,
            aeropuerto.nombreAeropuerto,
            aeropuerto.ciudadAeropuerto,
            aeropuerto.paisAeropuerto
        );
    }
}
