package com.example.vuelos.repositories;
import com.example.vuelos.entities.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {
    Optional<Aeropuerto> findByNombreAeropuerto(String nombreAeropuerto);
}
