package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.ClienteDTO;
import com.example.vuelos.controllers.dtos.ClienteRequestDTO;
import com.example.vuelos.controllers.dtos.PasajeroDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<ClienteDTO> findAll();

    Optional<ClienteDTO> findById(Long id);

    ClienteDTO create(ClienteRequestDTO clienteRequestDTO);

    Optional<ClienteDTO> update(Long id, ClienteRequestDTO clienteRequestDTO);

    void delete(Long id);

    Optional<ClienteDTO> findBynombre(String nombre);

    Optional<ClienteDTO> findByDocumentoIdentidad(String documentoIdentidad);
}
