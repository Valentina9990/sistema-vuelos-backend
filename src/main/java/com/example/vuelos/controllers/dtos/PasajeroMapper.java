package com.example.vuelos.controllers.dtos;
import com.example.vuelos.entities.Aeropuerto;
import com.example.vuelos.entities.Pasajero;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PasajeroMapper {
    PasajeroMapper INSTANCE = Mappers.getMapper(PasajeroMapper.class);

    PasajeroDTO toPasajeroDTO(Pasajero pasajero);

    Pasajero toPasajero(PasajeroDTO pasajeroDTO);

    Pasajero toPasajero(PasajeroRequestDTO pasajeroRequestDTO);
}
