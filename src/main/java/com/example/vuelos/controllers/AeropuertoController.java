package com.example.vuelos.controllers;

import com.example.vuelos.controllers.dtos.AeropuertoDTO;
import com.example.vuelos.controllers.dtos.AeropuertoRequestDTO;
import com.example.vuelos.exceptions.ResourceNotFound;
import com.example.vuelos.services.AeropuertoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/aeropuertos")
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
        return ResponseEntity.ok(aeropuertoService.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Aeropuerto no encontrado con id: " + id)));
    }

    @PostMapping
    public ResponseEntity<AeropuertoDTO> createAeropuerto(@RequestBody AeropuertoRequestDTO aeropuertoRequestDTO) {
        return ResponseEntity.ok(aeropuertoService.create(aeropuertoRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AeropuertoDTO> updateAeropuerto(@RequestBody AeropuertoRequestDTO aeropuertoRequestDTO, @PathVariable Long id) {
        return ResponseEntity.ok(aeropuertoService.update(id, aeropuertoRequestDTO)
                .orElseThrow(() -> new ResourceNotFound("Aeropuerto no encontrado con id: " + id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAeropuerto(@PathVariable Long id) {
        if (!aeropuertoService.findById(id).isPresent()) {
            throw new ResourceNotFound("Aeropuerto no encontrado con id: " + id);
        }
        aeropuertoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<AeropuertoDTO>> getAeropuertosByName(@RequestParam String name) {
        return ResponseEntity.ok(aeropuertoService.findByNombre(name));
    }
}
