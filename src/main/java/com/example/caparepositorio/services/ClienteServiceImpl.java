package com.example.caparepositorio.services;

import com.example.caparepositorio.entities.Cliente;
import com.example.caparepositorio.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> update(Long id, Cliente clienteToUpdate) {
        return clienteRepository.findById(id).map(cliente -> {
            Cliente updatedCliente = cliente.actualizarCon(clienteToUpdate);
            return clienteRepository.save(updatedCliente);
        });
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> findBynombre(String nombre) {
        return clienteRepository.findByNombreCliente(nombre);
    }
}
