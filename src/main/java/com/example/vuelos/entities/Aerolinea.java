package com.example.vuelos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "aerolinea")
    private Set<Vuelo> vuelos;
}
