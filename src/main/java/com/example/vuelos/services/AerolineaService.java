package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.AerolineaDTO;
import com.example.vuelos.controllers.dtos.AerolineaRequestDTO;

import java.util.List;
import java.util.Optional;

public interface AerolineaService {
    List<AerolineaDTO> findAll();

    Optional<AerolineaDTO> findById(Long id);

    AerolineaDTO create(AerolineaRequestDTO aerolineaRequestDTO);

    Optional<AerolineaDTO> update(Long id, AerolineaRequestDTO aerolineaRequestDTO);

    void delete(Long id);

    List<AerolineaDTO> findByAirlineCode(String code);
}
