package com.example.caparepositorio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "aerolineas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAerolinea;
    private String nombreAerolinea;
    private String codigoAerolinea;
    private String paisOrigenAerolinea;

    @OneToMany(mappedBy = "aerolinea")
    private Set<Vuelo> vuelos;

    public Aerolinea actualizarCon(Aerolinea aerolinea) {
        return new Aerolinea(
            this.idAerolinea,
            aerolinea.nombreAerolinea,
            aerolinea.codigoAerolinea,
            aerolinea.paisOrigenAerolinea,
            aerolinea.vuelos
        );
    }

}
