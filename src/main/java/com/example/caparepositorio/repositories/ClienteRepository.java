package com.example.caparepositorio.repositories;
import com.example.caparepositorio.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Optional<Cliente> findByNombreCliente(String nombreCliente);
}
