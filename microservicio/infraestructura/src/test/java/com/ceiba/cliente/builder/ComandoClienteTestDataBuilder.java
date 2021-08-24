package com.ceiba.cliente.builder;

import com.ceiba.cliente.comando.ComandoCliente;

import java.time.LocalDate;

public class ComandoClienteTestDataBuilder {
    private Long id;
    private String nombre;
    private String cedula;
    private String genero;
    private LocalDate fecha;

    public ComandoClienteTestDataBuilder() {
        nombre = "Emily Contreras";
        cedula = "45654";
        genero = "M";
        fecha = LocalDate.of(2000,8,2);
    }

    public ComandoClienteTestDataBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoClienteTestDataBuilder setGenero(String genero) {
        this.genero = genero;
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
        return new ComandoCliente(id,nombre, cedula, genero, fecha);
    }
}
