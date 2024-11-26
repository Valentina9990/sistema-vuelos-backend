package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.*;
import com.example.vuelos.entities.Pasajero;
import com.example.vuelos.exceptions.DuplicateDocumentException;
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
    public PasajeroDTO create(PasajeroRequestDTO pasajeroRequestDTO) {
        pasajeroRepository.findByDocumentoIdentidadPasajero(pasajeroRequestDTO.documentoIdentidadPasajero())
                .ifPresent(pasajero -> {
                    throw new DuplicateDocumentException("Ya existe un pasajero con el documento de identidad: "
                            + pasajeroRequestDTO.documentoIdentidadPasajero());
                });
        Pasajero pasajero = pasajeroMapper.toPasajero(pasajeroRequestDTO);
        Pasajero savedPasajero = pasajeroRepository.save(pasajero);
        return pasajeroMapper.toPasajeroDTO(savedPasajero);
    }

    @Override
    public Optional<PasajeroDTO> update(Long id, PasajeroRequestDTO pasajeroRequestDTO) {
        return pasajeroRepository.findById(id)
                .map(pasajeroExistente -> {
                    pasajeroRepository.findByDocumentoIdentidadPasajero(pasajeroRequestDTO.documentoIdentidadPasajero())
                            .ifPresent(existingPasajero -> {
                                if (!existingPasajero.getIdPasajero().equals(id)) {
                                    throw new DuplicateDocumentException("Ya existe otro pasajero con el documento de identidad: "
                                            + pasajeroRequestDTO.documentoIdentidadPasajero());
                                }
                            });
                    pasajeroMapper.updatePasajeroFromDTO(pasajeroRequestDTO, pasajeroExistente);
                    Pasajero pasajeroActualizado = pasajeroRepository.save(pasajeroExistente);
                    return pasajeroMapper.toPasajeroDTO(pasajeroActualizado);
                });
    }

    @Override
    public void delete(Long id) {
        pasajeroRepository.deleteById(id);
    }

    @Override
    public Optional<PasajeroDTO> findByDocumentoIdentidad(String documentoIdentidad) {
        return pasajeroRepository.findByDocumentoIdentidadPasajero(documentoIdentidad)
                .map(pasajeroMapper::toPasajeroDTO);
    }
}
