package com.example.caparepositorio.controllers;

import com.example.caparepositorio.entities.Pasajero;
import com.example.caparepositorio.services.PasajeroService;
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
    public ResponseEntity<List<Pasajero>> getPasajeros() {
        return ResponseEntity.ok(pasajeroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pasajero> getPasajeroById(@PathVariable Long id) {
        return pasajeroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pasajero> createPasajero(@RequestBody Pasajero pasajero) {
        return ResponseEntity.ok(pasajeroService.create(pasajero));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pasajero> updatePasajero(@RequestBody Pasajero pasajeroToUpdate, @PathVariable Long id) {
        return pasajeroService.update(id, pasajeroToUpdate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePasajero(@PathVariable Long id) {
        pasajeroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
