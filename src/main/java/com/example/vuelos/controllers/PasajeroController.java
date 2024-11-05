package com.example.vuelos.controllers;

import com.example.vuelos.controllers.dtos.PasajeroDTO;
import com.example.vuelos.controllers.dtos.PasajeroRequestDTO;
import com.example.vuelos.exceptions.ResourceNotFound;
import com.example.vuelos.services.PasajeroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pasajeros")
public class PasajeroController {
    private final PasajeroService pasajeroService;

    public PasajeroController(PasajeroService pasajeroService) {
        this.pasajeroService = pasajeroService;
    }

    @GetMapping
    public ResponseEntity<List<PasajeroDTO>> getPasajeros() {
        return ResponseEntity.ok(pasajeroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PasajeroDTO> getPasajeroById(@PathVariable Long id) {
        return ResponseEntity.ok(pasajeroService.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Pasajero no encontrado con id: " + id)));
    }

    @PostMapping
    public ResponseEntity<PasajeroDTO> createPasajero(@RequestBody PasajeroRequestDTO pasajeroRequestDTO) {
        return ResponseEntity.ok(pasajeroService.create(pasajeroRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PasajeroDTO> updatePasajero(@RequestBody PasajeroRequestDTO pasajeroRequestDTO, @PathVariable Long id) {
        return ResponseEntity.ok(pasajeroService.update(id, pasajeroRequestDTO)
                .orElseThrow(() -> new ResourceNotFound("Pasajero no encontrado con id: " + id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePasajero(@PathVariable Long id) {
        if (!pasajeroService.findById(id).isPresent()) {
            throw new ResourceNotFound("Pasajero no encontrado con id: " + id);
        }
        pasajeroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
