package com.example.vuelos.controllers.dtos;
import com.example.vuelos.entities.Vuelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VueloMapper {
    VueloMapper INSTANCE = Mappers.getMapper(VueloMapper.class);

    @Mapping(target = "aerolinea.idAerolinea", source = "aerolineaId")
    @Mapping(target = "aeropuertoOrigen.idAeropuerto", source = "aeropuertoOrigenId")
    @Mapping(target = "aeropuertoDestino.idAeropuerto", source = "aeropuertoDestinoId")
    Vuelo toVuelo(VueloRequestDTO vueloRequestDTO);

    VueloDTO toVueloDTO(Vuelo vuelo);

    @Mapping(target = "idVuelo", ignore = true)
    @Mapping(target = "aerolinea.idAerolinea", source = "aerolineaId")
    @Mapping(target = "aeropuertoOrigen.idAeropuerto", source = "aeropuertoOrigenId")
    @Mapping(target = "aeropuertoDestino.idAeropuerto", source = "aeropuertoDestinoId")
    void updateVueloFromDTO(VueloRequestDTO vueloRequestDTO, @MappingTarget Vuelo vuelo);
}
