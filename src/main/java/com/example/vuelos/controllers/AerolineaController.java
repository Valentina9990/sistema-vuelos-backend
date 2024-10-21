package com.example.vuelos.controllers;

import com.example.vuelos.dtos.AerolineaDTO;
import com.example.vuelos.services.AerolineaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/aerolineas")
public class AerolineaController {
    private final AerolineaService aerolineaService;

    public AerolineaController(AerolineaService aerolineaService) {
        this.aerolineaService = aerolineaService;
    }

    @GetMapping
    public ResponseEntity<List<AerolineaDTO>> getAerolineas() {
        return ResponseEntity.ok(aerolineaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AerolineaDTO> getAerolineaById(@PathVariable Long id) {
        return aerolineaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AerolineaDTO> createAerolinea(@RequestBody AerolineaDTO aerolineaDTO) {
        return ResponseEntity.ok(aerolineaService.create(aerolineaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AerolineaDTO> updateAerolinea(@RequestBody AerolineaDTO aerolineaToUpdateDTO, @PathVariable Long id) {
        return aerolineaService.update(id, aerolineaToUpdateDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAerolinea(@PathVariable Long id) {
        aerolineaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
