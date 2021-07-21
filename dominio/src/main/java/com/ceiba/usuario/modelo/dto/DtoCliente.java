package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCliente {
    private Long id;
    private String nombre;
    private String cedula;
    private String genero;
    private String precioEntrada;
    private LocalDateTime fechaNacimiento;
}
