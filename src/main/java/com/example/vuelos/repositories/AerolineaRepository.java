package com.example.vuelos.repositories;
import com.example.vuelos.entities.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {
    List<Aerolinea> findByNombreAerolineaContainingIgnoreCase(String code);
}
