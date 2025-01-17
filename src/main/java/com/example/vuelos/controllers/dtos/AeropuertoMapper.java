package com.example.vuelos.controllers.dtos;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import com.example.vuelos.entities.Aeropuerto;

@Mapper
public interface AeropuertoMapper {
    AeropuertoMapper INSTANCE = Mappers.getMapper(AeropuertoMapper.class);

    AeropuertoDTO toAeropuertoDTO(Aeropuerto aeropuerto);

    Aeropuerto toAeropuerto(AeropuertoDTO aeropuertoDTO);

    Aeropuerto toAeropuerto(AeropuertoRequestDTO aeropuertoRequestDTO);

    void updateAeropuertoFromDTO(AeropuertoRequestDTO aeropuertoRequestDTO, @MappingTarget Aeropuerto aeropuerto);
}