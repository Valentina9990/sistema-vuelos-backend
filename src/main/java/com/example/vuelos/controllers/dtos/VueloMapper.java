package com.example.vuelos.controllers.dtos;
import com.example.vuelos.entities.Vuelo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VueloMapper {
    VueloMapper INSTANCE = Mappers.getMapper(VueloMapper.class);

    VueloDTO toVueloDTO(Vuelo vuelo);

    Vuelo toVuelo(VueloRequestDTO vueloRequestDTO);
}
