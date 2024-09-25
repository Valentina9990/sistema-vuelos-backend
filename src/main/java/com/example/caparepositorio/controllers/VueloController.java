package com.example.caparepositorio.controllers;

import com.example.caparepositorio.entities.Vuelo;
import com.example.caparepositorio.services.VueloService;
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
    public ResponseEntity<List<Vuelo>> getVuelos() {
        return ResponseEntity.ok(vueloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> getVueloById(@PathVariable Long id) {
        return vueloService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vuelo> createVuelo(@RequestBody Vuelo vuelo) {
        return ResponseEntity.ok(vueloService.create(vuelo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> updateVuelo(@RequestBody Vuelo vueloToUpdate, @PathVariable Long id) {
        return vueloService.update(id, vueloToUpdate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVuelo(@PathVariable Long id) {
        vueloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
