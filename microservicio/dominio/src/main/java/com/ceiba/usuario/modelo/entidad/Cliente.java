package com.ceiba.usuario.modelo.entidad;


import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.usuario.constante.DiaFinDeSemana;
import com.ceiba.usuario.constante.TipoGenero;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class Cliente {
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE = "Se debe ingresar el nombre del cliente";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cedula del cliente";
    private static final String SE_DEBE_INGRESAR_EL_GENERO = "Se debe ingresar el genero del cliente";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO = "Se debe ingresar la fecha de nacimiento del cliente";
    private static final String EL_CLIENTE_ES_MENOR_DE_EDAD = "El cliente es menor de edad";
    private static final Double PRECIO_ENTRADA_HOMBRE = 15000d;
    private static final Double PRECIO_ENTRADA_MUJER = 10000d;
    private static final Double TASA_AUMENTO_SADADO_O_DOMINGO = 0.05d;

    private Long id;
    private String nombre;
    private String cedula;
    private String genero;
    private LocalDate fechaNacimiento;
    public LocalDate fechaActual;

    public Cliente(Long id,String nombre, String cedula, String genero, LocalDate fechaNacimiento) {
        ValidadorArgumento.validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE);
        ValidadorArgumento.validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA);
        ValidadorArgumento.validarObligatorio(genero, SE_DEBE_INGRESAR_EL_GENERO);
        ValidadorArgumento.validarObligatorio(fechaNacimiento, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO);
        ValidadorArgumento.validarMayorEdad(fechaNacimiento,EL_CLIENTE_ES_MENOR_DE_EDAD);

        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaActual = LocalDate.now();
    }

}