package com.example.vuelos.controllers;

import com.example.vuelos.controllers.dtos.AerolineaDTO;
import com.example.vuelos.controllers.dtos.AerolineaRequestDTO;
import com.example.vuelos.exceptions.ResourceNotFound;
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
        return ResponseEntity.ok(aerolineaService.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Aerolínea no encontrada con id: " + id)));
    }

    @PostMapping
    public ResponseEntity<AerolineaDTO> createAerolinea(@RequestBody AerolineaRequestDTO aerolineaRequestDTO) {
        return ResponseEntity.ok(aerolineaService.create(aerolineaRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AerolineaDTO> updateAerolinea(@RequestBody AerolineaRequestDTO aerolineaRequestDTO, @PathVariable Long id) {
        return ResponseEntity.ok(aerolineaService.update(id, aerolineaRequestDTO)
                .orElseThrow(() -> new ResourceNotFound("Aerolínea no encontrada con id: " + id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAerolinea(@PathVariable Long id) {
        if (!aerolineaService.findById(id).isPresent()) {
            throw new ResourceNotFound("Aerolínea no encontrada con id: " + id);
        }
        aerolineaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
