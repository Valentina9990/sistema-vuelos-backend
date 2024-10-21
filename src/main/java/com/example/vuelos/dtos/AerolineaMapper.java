package com.example.vuelos.dtos;
import com.example.vuelos.entities.Aerolinea;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AerolineaMapper {
    AerolineaMapper INSTANCE = Mappers.getMapper(AerolineaMapper.class);

    AerolineaDTO toAerolineaDTO(Aerolinea aerolinea);

    Aerolinea toAerolinea(AerolineaDTO aerolineaDTO);
}
