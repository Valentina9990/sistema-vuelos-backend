package com.example.vuelos.repositories;
import com.example.vuelos.controllers.dtos.VueloClientDTO;
import com.example.vuelos.entities.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
    @Query(value = """
                SELECT new com.example.vuelos.controllers.dtos.VueloClientDTO(
                    v.idVuelo,
                    v.fechaSalidaVuelo,
                    v.horaSalidaVuelo,
                    v.duracionMinutosVuelo,
                    v.capacidadVuelo,
                    v.precioVuelo,
                    v.aerolinea,
                    v.aeropuertoOrigen,
                    v.aeropuertoDestino,
                    COUNT(p),
                    COUNT(r)
                )
                FROM Vuelo v
                LEFT JOIN v.reservas r
                LEFT JOIN r.pasajeros p
                WHERE v.fechaSalidaVuelo >= :date
                AND (LOWER(v.aeropuertoOrigen.paisAeropuerto) LIKE LOWER(CONCAT('%', :origin, '%')) OR LOWER(v.aeropuertoOrigen.ciudadAeropuerto) LIKE LOWER(CONCAT('%', :origin, '%')))
                AND (LOWER(v.aeropuertoDestino.paisAeropuerto) LIKE LOWER(CONCAT('%', :destination, '%')) OR LOWER(v.aeropuertoDestino.ciudadAeropuerto) LIKE LOWER(CONCAT('%', :destination, '%')))
                GROUP BY v.idVuelo, v.aeropuertoOrigen, v.aeropuertoDestino, v.aerolinea
                ORDER BY v.fechaSalidaVuelo
                LIMIT :size
                OFFSET :page
            """)
    List<VueloClientDTO> getFlightsByCriteria(String origin, String destination, LocalDate date, Integer page, Integer size);
}
