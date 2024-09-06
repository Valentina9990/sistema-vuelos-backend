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
    private Long id_aeropuerto;
    private String nombre_aeropuerto;
    private String ciudad_aeropuerto;
    private String pais_aeropuerto;

    @OneToMany(mappedBy = "aeropuerto_origen")
    private Set<Vuelo> vuelo_origen;

    @OneToMany(mappedBy = "aeropuerto_destino")
    private Set<Vuelo> vuelo_destino;

}
