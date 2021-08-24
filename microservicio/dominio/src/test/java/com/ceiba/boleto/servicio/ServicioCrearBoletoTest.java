package com.ceiba.boleto.servicio;


import com.ceiba.boleto.builder.BoletoTestBuilder;
import com.ceiba.boleto.modelo.entidad.Boleto;
import com.ceiba.boleto.puerto.repositorio.RepositorioBoleto;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class ServicioCrearBoletoTest {

    RepositorioBoleto repositorioBoleto;

    @Before
    public void instanciarBoleto(){
        repositorioBoleto =mock(RepositorioBoleto.class);
    }

    /**
     * Prueba el caso de que entre alguien que este cumpliendo años
     */
    @Test
    public void validarIngresoClienteCumpleañeroTest() {
        // Arrange
        Boleto voleto = new BoletoTestBuilder().build();
        voleto.getCliente().setFechaNacimiento(LocalDate.of(1998,LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()));
        ServicioCrearBoleto servicioCrearVoleto = new ServicioCrearBoleto(repositorioBoleto);
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
        Boleto voleto = new BoletoTestBuilder().build();
        voleto.getCliente().setFechaNacimiento(LocalDate.of(2000,01,01));
        voleto.getCliente().setGenero("M");
        ServicioCrearBoleto servicioCrearVoleto = new ServicioCrearBoleto(repositorioBoleto);
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
        Boleto voleto = new BoletoTestBuilder().build();
        voleto.getCliente().setFechaNacimiento(LocalDate.of(2000,1,1));
        voleto.getCliente().setGenero("M");
        voleto.setFechaIngreso(LocalDate.of(2021,8,22));
        ServicioCrearBoleto servicioCrearVoleto = new ServicioCrearBoleto(repositorioBoleto);
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
        Boleto voleto = new BoletoTestBuilder().build();
        voleto.getCliente().setFechaNacimiento(LocalDate.of(2000,01,01));
        voleto.getCliente().setGenero("H");
        ServicioCrearBoleto servicioCrearVoleto = new ServicioCrearBoleto(repositorioBoleto);
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
        Boleto voleto = new BoletoTestBuilder().build();
        voleto.getCliente().setFechaNacimiento(LocalDate.of(2000,01,01));
        voleto.getCliente().setGenero("H");
        voleto.setFechaIngreso(LocalDate.of(LocalDate.now().getYear(),01,02));
        ServicioCrearBoleto servicioCrearVoleto = new ServicioCrearBoleto(repositorioBoleto);
        // Act
        servicioCrearVoleto.ejecutar(voleto);
        // Assert
        assertTrue(voleto.getPrecioEntrada() == 15750);
    }

}
