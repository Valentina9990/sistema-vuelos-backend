package com.example.vuelos.services;

import com.example.vuelos.dtos.AeropuertoDTO;
import com.example.vuelos.dtos.AeropuertoMapper;
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
    public AeropuertoDTO create(AeropuertoDTO aeropuertoDTO) {
        Aeropuerto aeropuerto = aeropuertoMapper.toAeropuerto(aeropuertoDTO);
        Aeropuerto savedAeropuerto = aeropuertoRepository.save(aeropuerto);
        return aeropuertoMapper.toAeropuertoDTO(savedAeropuerto);
    }

    @Override
    public Optional<AeropuertoDTO> update(Long id, AeropuertoDTO aeropuertoToUpdateDTO) {
        return aeropuertoRepository.findById(id).map(aeropuerto -> {
            Aeropuerto updatedAeropuerto = aeropuerto.actualizarCon(aeropuertoMapper.toAeropuerto(aeropuertoToUpdateDTO));
            Aeropuerto savedAeropuerto = aeropuertoRepository.save(updatedAeropuerto);
            return aeropuertoMapper.toAeropuertoDTO(savedAeropuerto);
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
