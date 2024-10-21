package com.example.vuelos.repositories;
import com.example.vuelos.entities.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
}
