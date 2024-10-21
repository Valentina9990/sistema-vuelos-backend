package com.example.vuelos.services;

import com.example.vuelos.dtos.PasajeroDTO;
import com.example.vuelos.dtos.PasajeroMapper;
import com.example.vuelos.entities.Pasajero;
import com.example.vuelos.repositories.PasajeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajeroServiceImpl implements PasajeroService {
    private final PasajeroRepository pasajeroRepository;
    private final PasajeroMapper pasajeroMapper = PasajeroMapper.INSTANCE;

    public PasajeroServiceImpl(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    @Override
    public List<PasajeroDTO> findAll() {
        return pasajeroRepository.findAll().stream()
                .map(pasajeroMapper::toPasajeroDTO)
                .toList();
    }

    @Override
    public Optional<PasajeroDTO> findById(Long id) {
        return pasajeroRepository.findById(id)
                .map(pasajeroMapper::toPasajeroDTO);
    }

    @Override
    public PasajeroDTO create(PasajeroDTO pasajeroDTO) {
        Pasajero pasajero = pasajeroMapper.toPasajero(pasajeroDTO);
        Pasajero savedPasajero = pasajeroRepository.save(pasajero);
        return pasajeroMapper.toPasajeroDTO(savedPasajero);
    }

    @Override
    public Optional<PasajeroDTO> update(Long id, PasajeroDTO pasajeroToUpdateDTO) {
        return pasajeroRepository.findById(id).map(pasajero -> {
            Pasajero updatedPasajero = pasajero.actualizarCon(pasajeroMapper.toPasajero(pasajeroToUpdateDTO));
            Pasajero savedPasajero = pasajeroRepository.save(updatedPasajero);
            return pasajeroMapper.toPasajeroDTO(savedPasajero);
        });
    }

    @Override
    public void delete(Long id) {
        pasajeroRepository.deleteById(id);
    }

    @Override
    public Optional<PasajeroDTO> findByDocumentoIdentidad(Integer documentoIdentidad) {
        return pasajeroRepository.findByDocumentoIdentidadPasajero(documentoIdentidad)
                .map(pasajeroMapper::toPasajeroDTO);
    }
}
