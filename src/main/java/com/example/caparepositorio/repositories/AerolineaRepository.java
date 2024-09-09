package com.example.caparepositorio.repositories;
import com.example.caparepositorio.entities.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {
    Optional<Aerolinea> findByCodigoAerolinea(String codigoAerolinea);
}
