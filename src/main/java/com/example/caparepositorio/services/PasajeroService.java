package com.example.caparepositorio.services;

import com.example.caparepositorio.entities.Pasajero;
import com.example.caparepositorio.repositories.PasajeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajeroService {
    private final PasajeroRepository pasajeroRepository;

    public PasajeroService(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    public List<Pasajero> findAll() {
        return pasajeroRepository.findAll();
    }

    public Optional<Pasajero> findById(Long id) {
        return pasajeroRepository.findById(id);
    }

    public Pasajero create(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }

    public Optional<Pasajero> update(Long id, Pasajero pasajeroToUpdate) {
        return pasajeroRepository.findById(id).map(pasajero -> {
            Pasajero updatedPasajero = pasajero.actualizarCon(pasajeroToUpdate);
            return pasajeroRepository.save(updatedPasajero);
        });
    }

    public void delete(Long id) {
        pasajeroRepository.deleteById(id);
    }

    public Optional<Pasajero> findByDocumentoIdentidad(Integer documentoIdentidad) {
        return pasajeroRepository.findByDocumentoIdentidadPasajero(documentoIdentidad);
    }
}
