package com.example.vuelos.controllers;

import com.example.vuelos.dtos.PasajeroDTO;
import com.example.vuelos.entities.Pasajero;
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
        return pasajeroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PasajeroDTO> createPasajero(@RequestBody PasajeroDTO pasajeroDTO) {
        return ResponseEntity.ok(pasajeroService.create(pasajeroDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PasajeroDTO> updatePasajero(@RequestBody PasajeroDTO pasajeroToUpdateDTO, @PathVariable Long id) {
        return pasajeroService.update(id, pasajeroToUpdateDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePasajero(@PathVariable Long id) {
        pasajeroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
