package com.example.caparepositorio.repositories;
import com.example.caparepositorio.entities.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {
    Optional<Pasajero> findByDocumentoIdentidadPasajero(Integer documentoIdentidadPasajero);
}
