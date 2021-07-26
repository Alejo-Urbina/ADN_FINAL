package com.ceiba.usuario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCliente {
    private Long id;
    private String nombre;
    private String cedula;
    private String genero;
    private Double precioEntrada;
    private LocalDate fechaNacimiento;
}
