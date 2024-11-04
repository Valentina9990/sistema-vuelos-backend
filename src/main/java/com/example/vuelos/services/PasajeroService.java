package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.PasajeroDTO;
import com.example.vuelos.controllers.dtos.PasajeroRequestDTO;

import java.util.List;
import java.util.Optional;

public interface PasajeroService {
    List<PasajeroDTO> findAll();

    Optional<PasajeroDTO> findById(Long id);

    PasajeroDTO create(PasajeroRequestDTO pasajeroRequestDTO);

    Optional<PasajeroDTO> update(Long id, PasajeroRequestDTO pasajeroRequestDTO);

    void delete(Long id);

    Optional<PasajeroDTO> findByDocumentoIdentidad(String documentoIdentidad);
}
