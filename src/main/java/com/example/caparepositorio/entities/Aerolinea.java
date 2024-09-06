package com.example.caparepositorio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "aerolineas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aerolinea;
    private String nombre_aerolinea;
    private String codigo_aerolinea;
    private String pais_origen_aerolinea;

    @OneToMany(mappedBy = "aerolinea")
    private Set<Vuelo> vuelos;

}
