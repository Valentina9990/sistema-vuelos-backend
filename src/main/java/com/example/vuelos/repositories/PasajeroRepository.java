package com.example.vuelos.repositories;
import com.example.vuelos.entities.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {
    Optional<Pasajero> findByDocumentoIdentidadPasajero(Integer documentoIdentidadPasajero);
}
