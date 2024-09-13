package com.example.caparepositorio.services;

import com.example.caparepositorio.entities.Aerolinea;

import java.util.List;
import java.util.Optional;

public interface AerolineaService {
    List<Aerolinea> findAll();

    Optional<Aerolinea> findById(Long id);

    Aerolinea create(Aerolinea aerolinea);

    Optional<Aerolinea> update(Long id, Aerolinea aerolineaToUpdate);

    void delete(Long id);

    Optional<Aerolinea> findByAirlineCode(String code);
}
