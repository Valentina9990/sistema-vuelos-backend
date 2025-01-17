package com.example.vuelos.controllers;

import com.example.vuelos.controllers.dtos.VueloClientDTO;
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

    @GetMapping("/all")
    public ResponseEntity<List<VueloDTO>> getAllVuelos() {
        return ResponseEntity.ok(vueloService.findAll());
    }

    @GetMapping
    public ResponseEntity<List<VueloClientDTO>> getVuelos(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam String date,
            @RequestParam Integer passengers,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
            ) {
        return ResponseEntity.ok(vueloService.findAllByCriteria(origin, destination, date, passengers, page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VueloClientDTO> getVueloById(@PathVariable Long id) {
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
