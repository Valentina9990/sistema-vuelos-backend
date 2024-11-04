package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.VueloDTO;
import com.example.vuelos.controllers.dtos.VueloMapper;
import com.example.vuelos.controllers.dtos.VueloRequestDTO;
import com.example.vuelos.entities.Vuelo;
import com.example.vuelos.repositories.VueloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloServiceImpl implements VueloService {
    private final VueloRepository vueloRepository;
    private final VueloMapper vueloMapper = VueloMapper.INSTANCE;

    public VueloServiceImpl(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @Override
    public List<VueloDTO> findAll() {
        return vueloRepository.findAll().stream()
                .map(vueloMapper::toVueloDTO)
                .toList();
    }

    @Override
    public Optional<VueloDTO> findById(Long id) {
        return vueloRepository.findById(id)
                .map(vueloMapper::toVueloDTO);
    }

    @Override
    public VueloDTO create(VueloRequestDTO vueloRequestDTO) {
        Vuelo vuelo = vueloMapper.toVuelo(vueloRequestDTO);
        Vuelo savedVuelo = vueloRepository.save(vuelo);
        return vueloMapper.toVueloDTO(savedVuelo);
    }

    @Override
    public Optional<VueloDTO> update(Long id, VueloRequestDTO vueloRequestDTO) {
        return vueloRepository.findById(id).map(vuelo -> {
            vueloMapper.updateVueloFromRequestDTO(vueloRequestDTO, vuelo);
            return vueloMapper.toVueloDTO(vueloRepository.save(vuelo));
        });
    }

    @Override
    public void delete(Long id) {
        vueloRepository.deleteById(id);
    }
}
