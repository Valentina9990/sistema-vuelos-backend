package com.example.caparepositorio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private String direccion_cliente;
    private String telefono_cliente;
    private String correo_electronico_cliente;

    @OneToOne(mappedBy = "cliente")
    private Reserva reserva;
}
