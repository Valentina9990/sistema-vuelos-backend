package com.example.vuelos.dtos;
import com.example.vuelos.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO toClienteDTO(Cliente cliente);

    Cliente toCliente(ClienteDTO clienteDTO);
}
