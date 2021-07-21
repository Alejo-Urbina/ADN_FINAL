package com.ceiba.cliente.builder;

import com.ceiba.usuario.modelo.entidad.Cliente;

import java.time.LocalDateTime;

public class ClienteTestBuilder {
    private Long id;
    private String nombre;
    private String cedula;
    private String genero;
    private Double precioEntrada;
    private LocalDateTime fechaNacimiento;

    public ClienteTestBuilder() {
        this.id = 1L;
        this.nombre = "Giovy Urbina";
        this.cedula = "1090515821";
        this.genero = "M";
        this.precioEntrada = 0d;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPrecioEntrada(Double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente build(){
        return new Cliente(id,nombre,cedula,genero,precioEntrada,fechaNacimiento);
    }
}
