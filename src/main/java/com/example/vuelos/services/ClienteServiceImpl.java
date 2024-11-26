package com.example.vuelos.services;

import com.example.vuelos.controllers.dtos.*;
import com.example.vuelos.entities.Cliente;
import com.example.vuelos.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper= ClienteMapper.INSTANCE;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteDTO> findAll() {
        List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
        return clientes.stream()
                .map(clienteMapper::toClienteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteDTO> findById(Long id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::toClienteDTO);
    }

    @Override
    public ClienteDTO create(ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = clienteMapper.toCliente(clienteRequestDTO);
        Cliente savedCliente = clienteRepository.save(cliente);
        return clienteMapper.toClienteDTO(savedCliente);
    }

    @Override
    public Optional<ClienteDTO> update(Long id, ClienteRequestDTO clienteRequestDTO) {
        return clienteRepository.findById(id).map(cliente -> {
            clienteMapper.updateClienteFromRequestDTO(clienteRequestDTO, cliente);
            return clienteMapper.toClienteDTO(clienteRepository.save(cliente));
        });
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Optional<ClienteDTO> findBynombre(String nombre) {
        return clienteRepository.findByNombreCliente(nombre)
                .map(clienteMapper::toClienteDTO);
    }

    @Override
    public Optional<ClienteDTO> findByDocumentoIdentidad(String documentoIdentidad) {
        return clienteRepository.findByDocumentoIdentidad(documentoIdentidad)
                .map(clienteMapper::toClienteDTO);
    }
}
