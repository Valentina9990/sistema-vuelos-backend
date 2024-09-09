package com.example.caparepositorio.services;

import com.example.caparepositorio.entities.Aeropuerto;
import com.example.caparepositorio.repositories.AeropuertoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AeropuertoService {
    private final AeropuertoRepository aeropuertoRepository;

    public AeropuertoService(AeropuertoRepository aeropuertoRepository) {
        this.aeropuertoRepository = aeropuertoRepository;
    }

    public List<Aeropuerto> findAll() {
        return aeropuertoRepository.findAll();
    }

    public Optional<Aeropuerto> findById(Long id) {
        return aeropuertoRepository.findById(id);
    }

    public Aeropuerto create(Aeropuerto aeropuerto) {
        return aeropuertoRepository.save(aeropuerto);
    }

    public Optional<Aeropuerto> update(Long id, Aeropuerto aeropuertoToUpdate) {
        return aeropuertoRepository.findById(id).map(aeropuerto -> {
            Aeropuerto updatedAerolinea = aeropuerto.actualizarCon(aeropuertoToUpdate);
            return aeropuertoRepository.save(updatedAerolinea);
        });
    }

    public void delete(Long id) {
        aeropuertoRepository.deleteById(id);
    }

    public Optional<Aeropuerto> findByNombre(String nombre) {
        return aeropuertoRepository.findByNombreAeropuerto(nombre);
    }
}
