package com.ceiba.voleto.builder;

import com.ceiba.voleto.comando.ComandoVoleto;

import java.time.LocalDate;

public class ComandoVoletoTestDataBuilder {

    private Long id;
    private LocalDate fechaIngreso;
    private double precioEntrada;
    private Long idCliente;

    public ComandoVoletoTestDataBuilder() {
        this.fechaIngreso = LocalDate.of(2000,5,5);
        this.precioEntrada = 10000d;
        this.idCliente = 2L;
    }

    public ComandoVoletoTestDataBuilder setPrecioEntrada(double precioEntrada){
        this.precioEntrada = precioEntrada;
        return this;
    }

    public ComandoVoletoTestDataBuilder setFechaIngreso(LocalDate fechaIngreso){
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public ComandoVoletoTestDataBuilder setIdCliente(Long idCliente){
        this.idCliente = idCliente;
        return this;
    }

    public ComandoVoleto build() {
        this.fechaIngreso = LocalDate.of(2000,5,5);
        this.precioEntrada = 10000d;
        this.idCliente = 1L;
        return new ComandoVoleto(id, fechaIngreso, precioEntrada, idCliente);
    }
}
