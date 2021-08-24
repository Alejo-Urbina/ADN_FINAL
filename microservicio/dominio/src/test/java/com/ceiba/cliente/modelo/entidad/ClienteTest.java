package com.ceiba.cliente.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.builder.ClienteTestBuilder;
import com.ceiba.dominio.excepcion.ExcepcionMayorEdad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class ClienteTest {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE = "Se debe ingresar el nombre del cliente";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cedula del cliente";
    private static final String SE_DEBE_INGRESAR_EL_GENERO = "Se debe ingresar el genero del cliente";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO = "Se debe ingresar la fecha de nacimiento del cliente";
    private static final String EL_CLIENTE_ES_MENOR_DE_EDAD = "El cliente es menor de edad";

    private ClienteTestBuilder clienteTestBuilder;


    @Before
    public void instanciarObjeto(){
        clienteTestBuilder = new ClienteTestBuilder();
    }

    /**
     * Prueba que se arroja la excepcion  de digitar el nombre y no dejarlo vacio
     */
    @Test
    public void validarExcepcionNombreTest() {
        // Arrange
        clienteTestBuilder.setNombre(null);
        // Act - Assert
        BasePrueba.assertThrows(clienteTestBuilder::build, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE);
    }

    /**
     * Prueba que se arroja la excepcion  de digitar la cedula y no dejarla vacia
     */
    @Test
    public void validarExcepcionCedulaTest() {
        // Arrange
        clienteTestBuilder.setCedula(null);
        // Act - Assert
        BasePrueba.assertThrows(clienteTestBuilder::build, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_CEDULA);
    }

    /**
     * Prueba que se arroja la excepcion  de digitar el genero y no dejarlo vacio
     */
    @Test
    public void validarExcepcionGeneroTest() {
        // Arrange
        clienteTestBuilder.setGenero(null);
        // Act - Assert
        BasePrueba.assertThrows(clienteTestBuilder::build, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_GENERO);
    }

    /**
     * Prueba que se arroja la excepcion  de digitar la fecha de nacimiento y no dejarla vacia
     */
    @Test
    public void validarExcepcionFechaNacimientoTest() {
        // Arrange
        clienteTestBuilder.setFechaNacimiento(null);
        // Act - Assert
        BasePrueba.assertThrows(clienteTestBuilder::build, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO);
    }

    /**
     * Prueba que se arroja la excepcion  de digitar la fecha de nacimiento y no dejarla vacia
     */
    @Test
    public void validarExcepcionMayorEdadTest() {
        // Arrange
        clienteTestBuilder.setFechaNacimiento(LocalDate.of(2010,2,15));
        // Act - Assert
        BasePrueba.assertThrows(clienteTestBuilder::build, ExcepcionMayorEdad.class, EL_CLIENTE_ES_MENOR_DE_EDAD);
    }
}
