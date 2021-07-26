package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoCliente {
    private Long id;
    private String nombre;
    private String cedula;
    private String genero;
    private Double precioEntrada;
    private LocalDate fechaNacimiento;
}
