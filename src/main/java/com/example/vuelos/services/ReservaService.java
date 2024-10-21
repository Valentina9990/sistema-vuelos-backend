package com.example.vuelos.services;

import com.example.vuelos.dtos.ReservaDTO;
import java.util.List;
import java.util.Optional;

public interface ReservaService {
    List<ReservaDTO> findAll();

    Optional<ReservaDTO> findById(Long id);

    ReservaDTO create(ReservaDTO reservaDTO);

    Optional<ReservaDTO> update(Long id, ReservaDTO reservaToUpdateDTO);

    void delete(Long id);
}
