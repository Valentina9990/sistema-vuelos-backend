package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.ReservaDTO;
import com.example.vuelos.controllers.dtos.ReservaMapper;
import com.example.vuelos.controllers.dtos.ReservaRequestDTO;
import com.example.vuelos.entities.Reserva;
import com.example.vuelos.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper = ReservaMapper.INSTANCE;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public List<ReservaDTO> findAll() {
        return reservaRepository.findAll().stream()
                .map(reservaMapper::toReservaDTO)
                .toList();
    }

    @Override
    public Optional<ReservaDTO> findById(Long id) {
        return reservaRepository.findById(id)
                .map(reservaMapper::toReservaDTO);
    }

    @Override
    public ReservaDTO create(ReservaRequestDTO reservaRequestDTO) {
        Reserva reserva = reservaMapper.toReserva(reservaRequestDTO);
        Reserva savedReserva = reservaRepository.save(reserva);
        return reservaMapper.toReservaDTO(savedReserva);
    }

    @Override
    public Optional<ReservaDTO> update(Long id, ReservaRequestDTO reservaRequestDTO) {
        return reservaRepository.findById(id).map(reserva -> reservaMapper.toReservaDTO(reservaRepository.save(reserva)));
    }

    @Override
    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }
}
