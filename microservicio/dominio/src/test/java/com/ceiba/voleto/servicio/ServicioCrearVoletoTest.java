package com.ceiba.voleto.servicio;


import com.ceiba.voleto.builder.VoletoTestBuilder;
import com.ceiba.voleto.modelo.entidad.Voleto;
import com.ceiba.voleto.puerto.repositorio.RepositorioVoleto;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class ServicioCrearVoletoTest {

    RepositorioVoleto repositorioVoleto;

    @Before
    public void instanciarVoleto(){
        repositorioVoleto =mock(RepositorioVoleto.class);
    }

    /**
     * Prueba el caso de que entre alguien que este cumpliendo años
     */
    @Test
    public void validarIngresoClienteCumpleañeroTest() {
        // Arrange
        Voleto voleto = new VoletoTestBuilder().build();
        voleto.getCliente().setFechaNacimiento(LocalDate.of(1998,LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()));
        ServicioCrearVoleto servicioCrearVoleto = new ServicioCrearVoleto(repositorioVoleto);
        // Act
        servicioCrearVoleto.ejecutar(voleto);
        // Assert
        assertTrue(voleto.getPrecioEntrada() == 0);
    }

    /**
     * Prueba el calculo del precio de una mujer al ingresar a la discoteca un dia entre semana
     */
    @Test
    public void validarPrecioClienteMujerDiaNormalTest() {
        // Arrange
        Voleto voleto = new VoletoTestBuilder().build();
        voleto.getCliente().setFechaNacimiento(LocalDate.of(2000,01,01));
        voleto.getCliente().setGenero("M");
        ServicioCrearVoleto servicioCrearVoleto = new ServicioCrearVoleto(repositorioVoleto);
        voleto.setFechaIngreso(LocalDate.of(LocalDate.now().getYear(),01,05));
        // Act
        servicioCrearVoleto.ejecutar(voleto);
        // Assert
        assertTrue(voleto.getPrecioEntrada() == 10000);

    }

    /**
     * Prueba el calculo del precio de una mujer al ingresar a la discoteca sea sabado o domingo cobrarle el 5% mas
     */
    @Test
    public void validarPrecioClienteMujerSabadoODomingoTest() {
        // Arrange
        Voleto voleto = new VoletoTestBuilder().build();
        voleto.getCliente().setFechaNacimiento(LocalDate.of(2000,1,1));
        voleto.getCliente().setGenero("M");
        voleto.setFechaIngreso(LocalDate.of(2021,8,22));
        ServicioCrearVoleto servicioCrearVoleto = new ServicioCrearVoleto(repositorioVoleto);
        // Act
        servicioCrearVoleto.ejecutar(voleto);
        // Assert
        assertTrue(voleto.getPrecioEntrada() == 10500);

    }

    /**
     * Prueba el calculo del precio de un hombre al ingresar a la discoteca un dia entre semana
     */
    @Test
    public void validarPrecioClienteHombreDiaNormalTest() {
        // Arrange
        Voleto voleto = new VoletoTestBuilder().build();
        voleto.getCliente().setFechaNacimiento(LocalDate.of(2000,01,01));
        voleto.getCliente().setGenero("H");
        ServicioCrearVoleto servicioCrearVoleto = new ServicioCrearVoleto(repositorioVoleto);
        voleto.setFechaIngreso(LocalDate.of(LocalDate.now().getYear(),01,06));
        // Act
        servicioCrearVoleto.ejecutar(voleto);
        // Assert
        assertTrue(voleto.getPrecioEntrada() == 15000);
    }

    /**
     * Prueba el calculo del precio de un hombre al ingresar a la discoteca sea sabado o domingo cobrarle el 5% mas
     */
    @Test
    public void validarPrecioClienteHombreSabadoODomingoTest() {
        // Arrange
        Voleto voleto = new VoletoTestBuilder().build();
        voleto.getCliente().setFechaNacimiento(LocalDate.of(2000,01,01));
        voleto.getCliente().setGenero("H");
        voleto.setFechaIngreso(LocalDate.of(LocalDate.now().getYear(),01,02));
        ServicioCrearVoleto servicioCrearVoleto = new ServicioCrearVoleto(repositorioVoleto);
        // Act
        servicioCrearVoleto.ejecutar(voleto);
        // Assert
        assertTrue(voleto.getPrecioEntrada() == 15750);
    }

}
