package com.example.caparepositorio.services;

import com.example.caparepositorio.entities.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {
    List<Reserva> findAll();

    Optional<Reserva> findById(Long id);

    Reserva create(Reserva reserva);

    Optional<Reserva> update(Long id, Reserva reservaToUpdate);

    void delete(Long id);
}
