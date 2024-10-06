package com.example.vuelos.services;

import com.example.vuelos.dtos.AeropuertoDTO;
import com.example.vuelos.entities.Aeropuerto;

import java.util.List;
import java.util.Optional;

public interface AeropuertoService {
    List<AeropuertoDTO> findAll();

    Optional<AeropuertoDTO> findById(Long id);

    AeropuertoDTO create(AeropuertoDTO aeropuertoDTO);

    Optional<AeropuertoDTO> update(Long id, AeropuertoDTO aeropuertoToUpdateDTO);

    void delete(Long id);

    Optional<AeropuertoDTO> findByNombre(String nombre);
}
