package com.ceiba.cliente.builder;

import com.ceiba.usuario.modelo.entidad.Cliente;

import java.time.LocalDate;

public class ClienteTestBuilder {
    private Long id;
    private String nombre;
    private String cedula;
    private String genero;
    private Double precioEntrada;
    private LocalDate fechaNacimiento;

    public ClienteTestBuilder() {
        this.id = 1L;
        this.nombre = "Giovy Urbina";
        this.cedula = "1090515821";
        this.genero = "M";
        this.precioEntrada = 0d;
        this.fechaNacimiento = LocalDate.of(2000,05,03);
    }

    public ClienteTestBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ClienteTestBuilder setCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public ClienteTestBuilder setGenero(String genero) {
        this.genero = genero;
        return this;
    }

    public ClienteTestBuilder setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public Cliente build(){
        return new Cliente(id,nombre,cedula,genero,precioEntrada,fechaNacimiento);
    }
}
