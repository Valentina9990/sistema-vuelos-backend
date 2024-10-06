package com.example.vuelos.controllers;

import com.example.vuelos.dtos.VueloDTO;
import com.example.vuelos.entities.Vuelo;
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
        return vueloService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VueloDTO> createVuelo(@RequestBody VueloDTO vueloDTO) {
        return ResponseEntity.ok(vueloService.create(vueloDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VueloDTO> updateVuelo(@RequestBody VueloDTO vueloToUpdateDTO, @PathVariable Long id) {
        return vueloService.update(id, vueloToUpdateDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVuelo(@PathVariable Long id) {
        vueloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
