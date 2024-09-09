package com.example.caparepositorio.services;

import com.example.caparepositorio.entities.Reserva;
import com.example.caparepositorio.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva create(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Optional<Reserva> update(Long id, Reserva reservaToUpdate) {
        return reservaRepository.findById(id).map(reserva -> {
            Reserva updatedReserva = reserva.actualizarCon(reservaToUpdate);
            return reservaRepository.save(updatedReserva);
        });
    }

    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }
}
