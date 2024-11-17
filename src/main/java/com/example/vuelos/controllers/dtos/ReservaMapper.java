package com.example.vuelos.controllers.dtos;
import com.example.vuelos.entities.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservaMapper {
    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    ReservaDTO toReservaDTO(Reserva reserva);

    Reserva toReserva(ReservaDTO reservaDTO);

    Reserva toReserva(ReservaRequestDTO reservaRequestDTO);
}

