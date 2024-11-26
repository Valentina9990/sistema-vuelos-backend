package com.example.vuelos.repositories;
import com.example.vuelos.entities.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {
    List<Aeropuerto> findByNombreAeropuertoContainingIgnoreCase(String nombreAeropuerto);
}
