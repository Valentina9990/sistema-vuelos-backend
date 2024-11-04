package com.example.vuelos.controllers.dtos;
import com.example.vuelos.entities.Aerolinea;
import com.example.vuelos.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AerolineaMapper {
    AerolineaMapper INSTANCE = Mappers.getMapper(AerolineaMapper.class);

    AerolineaDTO toAerolineaDTO(Aerolinea aerolinea);

    Aerolinea toAerolinea(AerolineaDTO aerolineaDTO);

    Aerolinea toAerolinea(AerolineaRequestDTO aerolineaRequestDTO);

    void updateAerolineaFromRequestDTO(AerolineaRequestDTO aerolineaRequestDTO, Aerolinea aerolinea);
}
