package com.example.vuelos.controllers;

import com.example.vuelos.controllers.dtos.ClienteDTO;
import com.example.vuelos.controllers.dtos.ClienteRequestDTO;
import com.example.vuelos.exceptions.ResourceNotFound;
import com.example.vuelos.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getClientes() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Cliente no encontrado con id: " + id)));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteDTO createdCliente = clienteService.create(clienteRequestDTO);
        return ResponseEntity.ok(createdCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@RequestBody ClienteRequestDTO clienteRequestDTO, @PathVariable Long id) {
        return ResponseEntity.ok(clienteService.update(id, clienteRequestDTO)
                .orElseThrow(() -> new ResourceNotFound("Cliente no encontrado con id: " + id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        if (!clienteService.findById(id).isPresent()) {
            throw new ResourceNotFound("Cliente no encontrado con id: " + id);
        }
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
