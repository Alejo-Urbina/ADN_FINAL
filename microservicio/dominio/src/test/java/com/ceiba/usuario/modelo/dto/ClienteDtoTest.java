package com.ceiba.usuario.modelo.dto;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

public class ClienteDtoTest {

    /**
     * Prueba el ingreso de los campos de un cliente a la discoteca
     */
    @Test
    public void validarCamposCliente(){
        // Arrange
        Long id = 1L;
        String nombre = "Gustavo Iglesias";
        String cedula = "1005042912";
        String genero = "H";
        Double precioEntrada = 0d;
        LocalDate fechaNacimiento = LocalDate.of(2000,06,11);
        // Act
        DtoCliente cliente = new DtoCliente(id,nombre,cedula,genero,precioEntrada,fechaNacimiento);
        // Assert
        assertTrue(id == cliente.getId() && nombre.equals(cliente.getNombre()) &&
                    cedula.equals(cliente.getCedula()) && genero.equals(cliente.getGenero()) &&
                    precioEntrada == cliente.getPrecioEntrada() &&
                    fechaNacimiento.equals(cliente.getFechaNacimiento()));
    }
}
