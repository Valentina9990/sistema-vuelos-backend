package com.example.caparepositorio.services;

import com.example.caparepositorio.entities.Aerolinea;
import com.example.caparepositorio.repositories.AerolineaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AerolineaService {
    private final AerolineaRepository aerolineaRepository;

    public AerolineaService(AerolineaRepository aerolineaRepository) {
        this.aerolineaRepository = aerolineaRepository;
    }

    public List<Aerolinea> findAll() {
        return aerolineaRepository.findAll();
    }

    public Optional<Aerolinea> findById(Long id) {
        return aerolineaRepository.findById(id);
    }

    public Aerolinea create(Aerolinea aerolinea) {
        return aerolineaRepository.save(aerolinea);
    }

    public Optional<Aerolinea> update(Long id, Aerolinea aerolineaToUpdate) {
        return aerolineaRepository.findById(id).map(aerolinea -> {
            Aerolinea updatedAerolinea = aerolinea.actualizarCon(aerolineaToUpdate);
            return aerolineaRepository.save(updatedAerolinea);
        });
    }

    public void delete(Long id) {
        aerolineaRepository.deleteById(id);
    }

    public Optional<Aerolinea> findByAirlineCode(String code) {
        return aerolineaRepository.findByCodigoAerolinea(code);
    }
}
