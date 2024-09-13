package com.example.caparepositorio.services;

import com.example.caparepositorio.entities.Vuelo;

import java.util.List;
import java.util.Optional;

public interface VueloService {
    List<Vuelo> findAll();

    Optional<Vuelo> findById(Long id);

    Vuelo create(Vuelo vuelo);

    Optional<Vuelo> update(Long id, Vuelo vueloToUpdate);

    void delete(Long id);
}
