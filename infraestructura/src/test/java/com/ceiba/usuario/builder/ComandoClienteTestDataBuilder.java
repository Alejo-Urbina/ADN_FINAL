package com.ceiba.usuario.builder;

import com.ceiba.usuario.comando.ComandoCliente;

import java.time.LocalDate;

public class ComandoClienteTestDataBuilder {
    private Long id;
    private String nombre;
    private String cedula;
    private String genero;
    private Double precioEntrada;
    private LocalDate fecha;

    public ComandoClienteTestDataBuilder() {
        nombre = "Emily Contreras";
        cedula = "45654";
        genero = "F";
        precioEntrada = 0d;
        fecha = LocalDate.of(2000,05,06);
    }

    public ComandoClienteTestDataBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoClienteTestDataBuilder setGenero(String genero) {
        this.genero = genero;
        return this;
    }

    public ComandoClienteTestDataBuilder setPrecioEntrada(Double precioEntrada) {
        this.precioEntrada = precioEntrada;
        return this;
    }

    public ComandoClienteTestDataBuilder setCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public ComandoClienteTestDataBuilder setfecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public ComandoCliente build() {
        return new ComandoCliente(id,nombre, cedula, genero, precioEntrada, fecha);
    }
}
