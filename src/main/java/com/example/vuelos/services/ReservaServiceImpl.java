package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.PasajeroMapper;
import com.example.vuelos.controllers.dtos.ReservaDTO;
import com.example.vuelos.controllers.dtos.ReservaMapper;
import com.example.vuelos.controllers.dtos.ReservaRequestDTO;
import com.example.vuelos.entities.Cliente;
import com.example.vuelos.entities.Pasajero;
import com.example.vuelos.entities.Reserva;
import com.example.vuelos.entities.Vuelo;
import com.example.vuelos.repositories.ClienteRepository;
import com.example.vuelos.repositories.PasajeroRepository;
import com.example.vuelos.repositories.ReservaRepository;
import com.example.vuelos.repositories.VueloRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper = ReservaMapper.INSTANCE;
    private final ClienteRepository clienteRepository;
    private final VueloRepository vueloRepository;
    private final PasajeroRepository pasajeroRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository, ClienteRepository clienteRepository, VueloRepository vueloRepository, PasajeroRepository pasajeroRepository) {
        this.reservaRepository = reservaRepository;
        this.clienteRepository = clienteRepository;
        this.vueloRepository = vueloRepository;
        this.pasajeroRepository = pasajeroRepository;
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

    @Transactional
    @Override
    public ReservaDTO create(ReservaRequestDTO reservaRequestDTO) {
        Reserva reserva = new Reserva();
        Cliente cliente = clienteRepository.findById(reservaRequestDTO.idCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + reservaRequestDTO.idCliente()));
        reserva.setCliente(cliente);
        Vuelo vuelo = vueloRepository.findById(reservaRequestDTO.idVuelo())
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado con id: " + reservaRequestDTO.idVuelo()));

        reserva.setVuelos(List.of(vuelo));

        Reserva savedReserva = reservaRepository.save(reserva);
        List<Pasajero> pasajeros = reservaRequestDTO.pasajeros().stream().map(PasajeroMapper.INSTANCE::toPasajero).toList();
        pasajeros.forEach(pasajero -> {
            pasajero.setReserva(savedReserva);
            pasajeroRepository.save(pasajero);
        });

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
