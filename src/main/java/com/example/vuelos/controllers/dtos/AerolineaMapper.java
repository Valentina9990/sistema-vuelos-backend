package com.example.vuelos.controllers.dtos;
import com.example.vuelos.entities.Aerolinea;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AerolineaMapper {
    AerolineaMapper INSTANCE = Mappers.getMapper(AerolineaMapper.class);

    AerolineaDTO toAerolineaDTO(Aerolinea aerolinea);

    Aerolinea toAerolinea(AerolineaDTO aerolineaDTO);

    Aerolinea toAerolinea(AerolineaRequestDTO aerolineaRequestDTO);

    @Mapping(target = "idAerolinea", ignore = true)
    void updateAerolineaFromDTO(AerolineaRequestDTO aerolineaRequestDTO, @MappingTarget Aerolinea aerolinea);
}
