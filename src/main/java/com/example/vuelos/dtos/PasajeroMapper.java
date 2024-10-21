package com.example.vuelos.dtos;
import com.example.vuelos.entities.Pasajero;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PasajeroMapper {
    PasajeroMapper INSTANCE = Mappers.getMapper(PasajeroMapper.class);

    PasajeroDTO toPasajeroDTO(Pasajero pasajero);

    Pasajero toPasajero(PasajeroDTO pasajeroDTO);
}

