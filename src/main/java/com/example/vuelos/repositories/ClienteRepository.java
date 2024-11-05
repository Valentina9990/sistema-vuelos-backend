package com.example.vuelos.repositories;
import com.example.vuelos.entities.Cliente;
import com.example.vuelos.entities.Pasajero;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Optional<Cliente> findByNombreCliente(String nombreCliente);
    Optional<Cliente> findByDocumentoIdentidad(String documentoIdentidad);
}
