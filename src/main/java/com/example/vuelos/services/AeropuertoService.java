package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.AeropuertoDTO;
import com.example.vuelos.controllers.dtos.AeropuertoRequestDTO;
import com.example.vuelos.entities.Aeropuerto;

import java.util.List;
import java.util.Optional;

public interface AeropuertoService {
    List<AeropuertoDTO> findAll();

    Optional<AeropuertoDTO> findById(Long id);

    AeropuertoDTO create(AeropuertoRequestDTO aeropuertoRequestDTO);

    Optional<AeropuertoDTO> update(Long id, AeropuertoRequestDTO aeropuertoRequestDTO);

    void delete(Long id);

    List<AeropuertoDTO> findByNombre(String nombre);
}
