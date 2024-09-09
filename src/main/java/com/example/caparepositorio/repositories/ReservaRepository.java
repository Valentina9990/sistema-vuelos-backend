package com.example.caparepositorio.repositories;
import com.example.caparepositorio.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
