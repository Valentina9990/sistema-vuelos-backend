package com.example.caparepositorio.services;

import com.example.caparepositorio.entities.Pasajero;

import java.util.List;
import java.util.Optional;

public interface PasajeroService {
    List<Pasajero> findAll();

    Optional<Pasajero> findById(Long id);

    Pasajero create(Pasajero pasajero);

    Optional<Pasajero> update(Long id, Pasajero pasajeroToUpdate);

    void delete(Long id);

    Optional<Pasajero> findByDocumentoIdentidad(Integer documentoIdentidad);
}
