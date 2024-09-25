package com.example.caparepositorio.controllers;

import com.example.caparepositorio.entities.Aerolinea;
import com.example.caparepositorio.services.AerolineaService;
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
    public ResponseEntity<List<Aerolinea>> getAerolineas() {
        return ResponseEntity.ok(aerolineaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aerolinea> getAerolineaById(@PathVariable Long id) {
        return aerolineaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aerolinea> createAerolinea(@RequestBody Aerolinea aerolinea) {
        System.out.println(aerolinea);
        return ResponseEntity.ok(aerolineaService.create(aerolinea));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aerolinea> updateAerolinea(@RequestBody Aerolinea aerolineaToUpdate, @PathVariable Long id) {
        return aerolineaService.update(id, aerolineaToUpdate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAerolinea(@PathVariable Long id) {
        aerolineaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
