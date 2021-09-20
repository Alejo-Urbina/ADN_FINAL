package com.ceiba.boleto.builder;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.boleto.modelo.entidad.Boleto;

import java.time.LocalDate;

public class BoletoTestBuilder {

    private Long id;
    private LocalDate fechaIngreso;
    private double precioEntrada;
    private Cliente cliente;

    public BoletoTestBuilder() {
        this.fechaIngreso = LocalDate.now();
        this.precioEntrada = 10000d;
        this.cliente = new Cliente(1L,"Lewi","1090654789","M",LocalDate.of(2000,5,5));
    }

    public BoletoTestBuilder setPrecioEntrada(double precioEntrada){
        this.precioEntrada = precioEntrada;
        return this;
    }

    public BoletoTestBuilder setFechaIngreso(LocalDate fechaIngreso){
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public BoletoTestBuilder setIdCliente(Cliente cliente){
        this.cliente = cliente;
        return this;
    }

    public Boleto build() {
        this.fechaIngreso = LocalDate.of(2000,5,5);
        this.precioEntrada = 10000d;
        this.cliente = new Cliente(1L,"Lewi","1090654789","M",LocalDate.of(2000,5,5));
        return new Boleto(cliente);
    }

}
