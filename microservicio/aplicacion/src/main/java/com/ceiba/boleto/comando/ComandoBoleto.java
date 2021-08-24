package com.ceiba.boleto.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoBoleto {
    private Long id;
    private LocalDate fechaIngreso;
    private double precioEntrada;
    private Long clienteId;
}
