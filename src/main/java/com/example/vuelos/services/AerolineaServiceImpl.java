package com.example.vuelos.services;

import com.example.vuelos.dtos.AerolineaDTO;
import com.example.vuelos.dtos.AerolineaMapper;
import com.example.vuelos.entities.Aerolinea;
import com.example.vuelos.repositories.AerolineaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AerolineaServiceImpl implements AerolineaService {
    private final AerolineaRepository aerolineaRepository;
    private final AerolineaMapper aerolineaMapper= AerolineaMapper.INSTANCE;

    public AerolineaServiceImpl(AerolineaRepository aerolineaRepository) {
        this.aerolineaRepository = aerolineaRepository;
    }

    @Override
    public List<AerolineaDTO> findAll() {
        return aerolineaRepository.findAll().stream()
                .map(aerolineaMapper::toAerolineaDTO)
                .toList();
    }

    @Override
    public Optional<AerolineaDTO> findById(Long id) {
        return aerolineaRepository.findById(id)
                .map(aerolineaMapper::toAerolineaDTO);
    }

    @Override
    public AerolineaDTO create(AerolineaDTO aerolineaDTO) {
        Aerolinea aerolinea = aerolineaMapper.toAerolinea(aerolineaDTO);
        Aerolinea savedAerolinea = aerolineaRepository.save(aerolinea);
        return aerolineaMapper.toAerolineaDTO(savedAerolinea);
    }

    @Override
    public Optional<AerolineaDTO> update(Long id, AerolineaDTO aerolineaToUpdateDTO) {
        return aerolineaRepository.findById(id).map(aerolinea -> {
            Aerolinea updatedAerolinea = aerolinea.actualizarCon(aerolineaMapper.toAerolinea(aerolineaToUpdateDTO));
            Aerolinea savedAerolinea = aerolineaRepository.save(updatedAerolinea);
            return aerolineaMapper.toAerolineaDTO(savedAerolinea);
        });
    }

    @Override
    public void delete(Long id) {
        aerolineaRepository.deleteById(id);
    }

    @Override
    public Optional<AerolineaDTO> findByAirlineCode(String code) {
        return aerolineaRepository.findByCodigoAerolinea(code)
                .map(aerolineaMapper::toAerolineaDTO);
    }
}
