package com.example.caparepositorio.services;

import com.example.caparepositorio.entities.Vuelo;
import com.example.caparepositorio.repositories.VueloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloService {
    private final VueloRepository vueloRepository;

    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    public List<Vuelo> findAll() {
        return vueloRepository.findAll();
    }

    public Optional<Vuelo> findById(Long id) {
        return vueloRepository.findById(id);
    }

    public Vuelo create(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    public Optional<Vuelo> update(Long id, Vuelo vueloToUpdate) {
        return vueloRepository.findById(id).map(vuelo -> {
            Vuelo updatedVuelo = vuelo.actualizarCon(vueloToUpdate);
            return vueloRepository.save(updatedVuelo);
        });
    }

    public void delete(Long id) {
        vueloRepository.deleteById(id);
    }
}
