package com.ceiba.boleto.builder;

import com.ceiba.boleto.comando.ComandoBoleto;

import java.time.LocalDate;

public class ComandoBoletoTestDataBuilder {

    private Long id;
    private LocalDate fechaIngreso;
    private double precioEntrada;
    private Long idCliente;

    public ComandoBoletoTestDataBuilder() {
        this.fechaIngreso = LocalDate.of(2000,5,5);
        this.precioEntrada = 10000d;
        this.idCliente = 2L;
    }

    public ComandoBoletoTestDataBuilder setPrecioEntrada(double precioEntrada){
        this.precioEntrada = precioEntrada;
        return this;
    }

    public ComandoBoletoTestDataBuilder setFechaIngreso(LocalDate fechaIngreso){
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public ComandoBoletoTestDataBuilder setIdCliente(Long idCliente){
        this.idCliente = idCliente;
        return this;
    }

    public ComandoBoleto build() {
        this.fechaIngreso = LocalDate.of(2000,5,5);
        this.precioEntrada = 10000d;
        this.idCliente = 1L;
        return new ComandoBoleto(id, fechaIngreso, precioEntrada, idCliente);
    }
}
