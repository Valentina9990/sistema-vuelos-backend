package com.example.vuelos.controllers.dtos;
import com.example.vuelos.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO toClienteDTO(Cliente cliente);

    Cliente toCliente(ClienteDTO clienteDTO);

    Cliente toCliente(ClienteRequestDTO clienteRequestDTO);

    void updateClienteFromRequestDTO(ClienteRequestDTO clienteRequestDTO, @MappingTarget Cliente cliente);
}
