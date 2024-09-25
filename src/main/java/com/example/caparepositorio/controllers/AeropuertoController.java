package com.example.caparepositorio.controllers;

import com.example.caparepositorio.entities.Aeropuerto;
import com.example.caparepositorio.services.AeropuertoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/eropuertos")
public class AeropuertoController {
    private final AeropuertoService aeropuertoService;

    public AeropuertoController(AeropuertoService aeropuertoService) {
        this.aeropuertoService = aeropuertoService;
    }

    @GetMapping
    public ResponseEntity<List<Aeropuerto>> getAeropuertos() {
        return ResponseEntity.ok(aeropuertoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aeropuerto> getAeropuertoById(@PathVariable Long id) {
        return aeropuertoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aeropuerto> createAeropuerto(@RequestBody Aeropuerto aeropuerto) {
        return ResponseEntity.ok(aeropuertoService.create(aeropuerto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aeropuerto> updateAeropuerto(@RequestBody Aeropuerto aeropuertoToUpdate, @PathVariable Long id) {
        return aeropuertoService.update(id, aeropuertoToUpdate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAeropuerto(@PathVariable Long id) {
        aeropuertoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
