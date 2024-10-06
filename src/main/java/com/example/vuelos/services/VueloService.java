package com.example.vuelos.services;

import com.example.vuelos.dtos.VueloDTO;

import java.util.List;
import java.util.Optional;

public interface VueloService {
    List<VueloDTO> findAll();

    Optional<VueloDTO> findById(Long id);

    VueloDTO create(VueloDTO vueloDTO);

    Optional<VueloDTO> update(Long id, VueloDTO vueloToUpdateDTO);

    void delete(Long id);
}
