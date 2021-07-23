package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Cliente {
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cedula de usuario";
    private static final String SE_DEBE_INGRESAR_EL_GENERO = "Se debe ingresar el genero de usuario";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO = "Se debe ingresar la fecha de nacimiento";

    private Long id;
    private String nombre;
    private String cedula;
    private String genero;
    private Double precioEntrada;
    private LocalDate fechaNacimiento;

    public Cliente(Long id,String nombre, String cedula, String genero, Double precioEntrada, LocalDate fechaNacimiento) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA);
        validarObligatorio(genero, SE_DEBE_INGRESAR_EL_GENERO);
        validarObligatorio(fechaNacimiento, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO);

        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.genero = genero;
        this.precioEntrada = precioEntrada;
        this.fechaNacimiento = fechaNacimiento;
    }
}
