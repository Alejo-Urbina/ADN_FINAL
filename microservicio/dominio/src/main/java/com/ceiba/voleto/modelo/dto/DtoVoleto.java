package com.ceiba.voleto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoVoleto {

    private Long id;
    private double precioEntrada;
    private LocalDate fechaIngreso;
    public Long cliente;

}
