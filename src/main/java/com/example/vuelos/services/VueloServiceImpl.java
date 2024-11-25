package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.*;
import com.example.vuelos.entities.Vuelo;
import com.example.vuelos.repositories.VueloRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class VueloServiceImpl implements VueloService {
    private final VueloRepository vueloRepository;
    private final VueloMapper vueloMapper = VueloMapper.INSTANCE;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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
    public Optional<VueloClientDTO> findById(Long id) {
        return vueloRepository.findByIdVuelo(id);
    }

    @Override
    public VueloDTO create(VueloRequestDTO vueloRequestDTO) {
        Vuelo vuelo = vueloMapper.toVuelo(vueloRequestDTO);
        Vuelo savedVuelo = vueloRepository.save(vuelo);
        return vueloMapper.toVueloDTO(savedVuelo);
    }

    @Override
    public Optional<VueloDTO> update(Long id, VueloRequestDTO vueloRequestDTO) {
        return vueloRepository.findById(id)
                .map(vueloExistente -> {
                    vueloMapper.updateVueloFromDTO(vueloRequestDTO, vueloExistente);
                    Vuelo vueloActualizado = vueloRepository.save(vueloExistente);
                    return vueloMapper.toVueloDTO(vueloActualizado);
                });
    }

    @Override
    public void delete(Long id) {
        vueloRepository.deleteById(id);
    }

    @Override
    public List<VueloClientDTO> findAllByCriteria(String origin, String destination, String date, Integer passengers, Integer page, Integer size) {
        return vueloRepository.getFlightsByCriteria(origin, destination, LocalDate.parse(date, formatter), page, size);
    }
}
