package com.example.caparepositorio.services;

import com.example.caparepositorio.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    Cliente create(Cliente cliente);

    Optional<Cliente> update(Long id, Cliente clienteToUpdate);

    void delete(Long id);

    Optional<Cliente> findBynombre(String nombre);
}
