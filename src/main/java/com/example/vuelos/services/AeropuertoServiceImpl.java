package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.AeropuertoDTO;
import com.example.vuelos.controllers.dtos.AeropuertoMapper;
import com.example.vuelos.controllers.dtos.AeropuertoRequestDTO;
import com.example.vuelos.entities.Aeropuerto;
import com.example.vuelos.repositories.AeropuertoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AeropuertoServiceImpl implements AeropuertoService {
    private final AeropuertoRepository aeropuertoRepository;
    private final AeropuertoMapper aeropuertoMapper = AeropuertoMapper.INSTANCE;

    public AeropuertoServiceImpl(AeropuertoRepository aeropuertoRepository) {
        this.aeropuertoRepository = aeropuertoRepository;
    }

    @Override
    public List<AeropuertoDTO> findAll() {
        return aeropuertoRepository.findAll().stream()
                .map(aeropuertoMapper::toAeropuertoDTO)
                .toList();
    }


    @Override
    public Optional<AeropuertoDTO> findById(Long id) {
        return aeropuertoRepository.findById(id)
                .map(aeropuertoMapper::toAeropuertoDTO);
    }

    @Override
    public AeropuertoDTO create(AeropuertoRequestDTO aeropuertoRequestDTO) {
        Aeropuerto aeropuerto = aeropuertoMapper.toAeropuerto(aeropuertoRequestDTO);
        Aeropuerto savedAeropuerto = aeropuertoRepository.save(aeropuerto);
        return aeropuertoMapper.toAeropuertoDTO(savedAeropuerto);
    }

    @Override
    public Optional<AeropuertoDTO> update(Long id, AeropuertoRequestDTO aeropuertoRequestDTO) {
        return aeropuertoRepository.findById(id).map(aeropuerto -> {
            aeropuertoMapper.updateAeropuertoFromRequestDTO(aeropuertoRequestDTO, aeropuerto);
            return aeropuertoMapper.toAeropuertoDTO(aeropuertoRepository.save(aeropuerto));
        });
    }

    public void delete(Long id) {
        aeropuertoRepository.deleteById(id);
    }

    @Override
    public Optional<AeropuertoDTO> findByNombre(String nombre) {
        return aeropuertoRepository.findByNombreAeropuerto(nombre)
                .map(aeropuertoMapper::toAeropuertoDTO);
    }
}
