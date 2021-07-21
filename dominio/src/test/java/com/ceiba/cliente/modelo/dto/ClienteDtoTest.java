package com.ceiba.cliente.modelo.dto;

import com.ceiba.usuario.modelo.dto.DtoCliente;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

public class ClienteDtoTest {

    @Test
    public void validarCedulaCliente(){
        // Arrange
        Long id = 1L;
        String nombre = "Gustavo Iglesias";
        String cedula = "1005042912";
        String genero = "H";
        Double precioEntrada = 0d;
        LocalDateTime fechaNacimiento = LocalDateTime.now();
        // Act
        DtoCliente cliente = new DtoCliente(id,nombre,cedula,genero,precioEntrada,fechaNacimiento);
        // Assert
        assertTrue(id == cliente.getId() && nombre.equals(cliente.getNombre()) &&
                    cedula.equals(cliente.getCedula()) && genero.equals(cliente.getGenero()) &&
                    precioEntrada == cliente.getPrecioEntrada() &&
                    fechaNacimiento.equals(cliente.getFechaNacimiento()));
    }
}
