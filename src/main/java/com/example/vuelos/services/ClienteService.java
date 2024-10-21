package com.example.vuelos.services;

import com.example.vuelos.dtos.ClienteDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<ClienteDTO> findAll();

    Optional<ClienteDTO> findById(Long id);

    ClienteDTO create(ClienteDTO clienteDTO);

    Optional<ClienteDTO> update(Long id, ClienteDTO clienteToUpdate);

    void delete(Long id);

    Optional<ClienteDTO> findBynombre(String nombre);
}
