package com.ceiba.voleto.builder;

import com.ceiba.usuario.modelo.entidad.Cliente;
import com.ceiba.voleto.modelo.entidad.Voleto;

import java.time.LocalDate;

public class VoletoTestBuilder {

    private Long id;
    private LocalDate fechaIngreso;
    private double precioEntrada;
    private Cliente cliente;

    public VoletoTestBuilder() {
        this.fechaIngreso = LocalDate.now();
        this.precioEntrada = 10000d;
        this.cliente = new Cliente(1L,"Lewi","1090654789","M",LocalDate.of(2000,5,5));
    }

    public VoletoTestBuilder setPrecioEntrada(double precioEntrada){
        this.precioEntrada = precioEntrada;
        return this;
    }

    public VoletoTestBuilder setFechaIngreso(LocalDate fechaIngreso){
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public VoletoTestBuilder setIdCliente(Cliente cliente){
        this.cliente = cliente;
        return this;
    }

    public Voleto build() {
        this.fechaIngreso = LocalDate.of(2000,5,5);
        this.precioEntrada = 10000d;
        this.cliente = new Cliente(1L,"Lewi","1090654789","M",LocalDate.of(2000,5,5));
        return new Voleto(id, precioEntrada, fechaIngreso, cliente);
    }

}
