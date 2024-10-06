package com.example.vuelos.services;

import com.example.vuelos.dtos.AerolineaDTO;

import java.util.List;
import java.util.Optional;

public interface AerolineaService {
    List<AerolineaDTO> findAll();

    Optional<AerolineaDTO> findById(Long id);

    AerolineaDTO create(AerolineaDTO aerolineaDTO);

    Optional<AerolineaDTO> update(Long id, AerolineaDTO aerolineaToUpdateDTO);

    void delete(Long id);

    Optional<AerolineaDTO> findByAirlineCode(String code);
}
