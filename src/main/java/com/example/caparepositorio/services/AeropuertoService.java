package com.example.caparepositorio.services;

import com.example.caparepositorio.entities.Aeropuerto;

import java.util.List;
import java.util.Optional;

public interface AeropuertoService {
    List<Aeropuerto> findAll();

    Optional<Aeropuerto> findById(Long id);

    Aeropuerto create(Aeropuerto aeropuerto);

    Optional<Aeropuerto> update(Long id, Aeropuerto aeropuertoToUpdate);

    void delete(Long id);

    Optional<Aeropuerto> findByNombre(String nombre);
}
