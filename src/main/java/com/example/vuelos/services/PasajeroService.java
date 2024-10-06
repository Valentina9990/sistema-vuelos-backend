package com.example.vuelos.services;

import com.example.vuelos.dtos.PasajeroDTO;

import java.util.List;
import java.util.Optional;

public interface PasajeroService {
    List<PasajeroDTO> findAll();

    Optional<PasajeroDTO> findById(Long id);

    PasajeroDTO create(PasajeroDTO pasajeroDTO);

    Optional<PasajeroDTO> update(Long id, PasajeroDTO pasajeroToUpdateDTO);

    void delete(Long id);

    Optional<PasajeroDTO> findByDocumentoIdentidad(Integer documentoIdentidad);
}
