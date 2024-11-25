package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.VueloClientDTO;
import com.example.vuelos.controllers.dtos.VueloDTO;
import com.example.vuelos.controllers.dtos.VueloRequestDTO;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface VueloService {
    List<VueloDTO> findAll();

    Optional<VueloClientDTO> findById(Long id);

    VueloDTO create(VueloRequestDTO vueloRequestDTO);

    Optional<VueloDTO> update(Long id, VueloRequestDTO vueloRequestDTO);

    void delete(Long id);

    List<VueloClientDTO> findAllByCriteria(String origin, String destination, String date, Integer passengers, Integer page, Integer size);
}
