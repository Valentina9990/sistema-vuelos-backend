package com.example.caparepositorio.repositories;
import com.example.caparepositorio.entities.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {
    Optional<Aeropuerto> findByNombreAeropuerto(String nombreAeropuerto);
}
