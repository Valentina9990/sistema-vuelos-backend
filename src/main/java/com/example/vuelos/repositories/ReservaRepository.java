package com.example.vuelos.repositories;
import com.example.vuelos.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> getReservasByCliente_IdCliente(Long idCliente);
}
