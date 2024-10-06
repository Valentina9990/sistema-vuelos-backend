package com.example.vuelos.repositories;
import com.example.vuelos.entities.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {
    Optional<Aerolinea> findByCodigoAerolinea(String codigoAerolinea);
}
