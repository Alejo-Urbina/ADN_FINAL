package com.ceiba.boleto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoBoleto {

    private Long id;
    private double precioEntrada;
    private LocalDate fechaIngreso;
    public Long cliente;

}
