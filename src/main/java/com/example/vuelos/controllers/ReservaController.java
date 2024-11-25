package com.example.vuelos.controllers;

import com.example.vuelos.controllers.dtos.ReservaDTO;
import com.example.vuelos.controllers.dtos.ReservaRequestDTO;
import com.example.vuelos.exceptions.ResourceNotFound;
import com.example.vuelos.services.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reservas")
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> getReservas() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> getReservaById(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Reserva no encontrada con id: " + id)));
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> createReserva(@RequestBody ReservaRequestDTO reservaRequestDTO) {
        return ResponseEntity.ok(reservaService.create(reservaRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> updateReserva(@RequestBody ReservaRequestDTO reservaRequestDTO, @PathVariable Long id) {
        return ResponseEntity.ok(reservaService.update(id, reservaRequestDTO)
                .orElseThrow(() -> new ResourceNotFound("Reserva no encontrada con id: " + id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        if (!reservaService.findById(id).isPresent()) {
            throw new ResourceNotFound("Reserva no encontrada con id: " + id);
        }
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<ReservaDTO>> getReservasByClienteId(@PathVariable Long idCliente) {
        return ResponseEntity.ok(reservaService.getReservasByClienteId(idCliente));
    }
}
