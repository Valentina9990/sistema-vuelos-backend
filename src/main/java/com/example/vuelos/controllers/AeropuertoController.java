package com.example.vuelos.controllers;

import com.example.vuelos.dtos.AeropuertoDTO;
import com.example.vuelos.services.AeropuertoService;
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
    public ResponseEntity<List<AeropuertoDTO>> getAeropuertos() {
        return ResponseEntity.ok(aeropuertoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AeropuertoDTO> getAeropuertoById(@PathVariable Long id) {
        return aeropuertoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AeropuertoDTO> createAeropuerto(@RequestBody AeropuertoDTO aeropuertoDTO) {
        return ResponseEntity.ok(aeropuertoService.create(aeropuertoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AeropuertoDTO> updateAeropuerto(@RequestBody AeropuertoDTO aeropuertoToUpdateDTO, @PathVariable Long id) {
        return aeropuertoService.update(id, aeropuertoToUpdateDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAeropuerto(@PathVariable Long id) {
        aeropuertoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
