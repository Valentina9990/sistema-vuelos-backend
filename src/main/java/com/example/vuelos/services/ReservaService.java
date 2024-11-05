package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.ReservaDTO;
import com.example.vuelos.controllers.dtos.ReservaRequestDTO;

import java.util.List;
import java.util.Optional;

public interface ReservaService {
    List<ReservaDTO> findAll();

    Optional<ReservaDTO> findById(Long id);

    ReservaDTO create(ReservaRequestDTO reservaRequestDTO);

    Optional<ReservaDTO> update(Long id, ReservaRequestDTO reservaRequestDTO);

    void delete(Long id);
}
