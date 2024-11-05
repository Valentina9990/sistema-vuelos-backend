package com.example.vuelos.controllers;

import com.example.vuelos.controllers.dtos.VueloDTO;
import com.example.vuelos.controllers.dtos.VueloRequestDTO;
import com.example.vuelos.exceptions.ResourceNotFound;
import com.example.vuelos.services.VueloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vuelos")
public class VueloController {
    private final VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping
    public ResponseEntity<List<VueloDTO>> getVuelos() {
        return ResponseEntity.ok(vueloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VueloDTO> getVueloById(@PathVariable Long id) {
        return ResponseEntity.ok(vueloService.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Vuelo no encontrado con id: " + id)));
    }

    @PostMapping
    public ResponseEntity<VueloDTO> createVuelo(@RequestBody VueloRequestDTO vueloRequestDTO) {
        return ResponseEntity.ok(vueloService.create(vueloRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VueloDTO> updateVuelo(@RequestBody VueloRequestDTO vueloRequestDTO, @PathVariable Long id) {
        return ResponseEntity.ok(vueloService.update(id, vueloRequestDTO)
                .orElseThrow(() -> new ResourceNotFound("Vuelo no encontrado con id: " + id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVuelo(@PathVariable Long id) {
        if (!vueloService.findById(id).isPresent()) {
            throw new ResourceNotFound("Vuelo no encontrado con id: " + id);
        }
        vueloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
