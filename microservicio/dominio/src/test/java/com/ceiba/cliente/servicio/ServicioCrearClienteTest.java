package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.builder.ClienteTestBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class ServicioCrearClienteTest {

    private RepositorioCliente repositorioCliente;

    @Before
    public void instanciarCliente(){
        repositorioCliente =mock(RepositorioCliente.class);
    }

    /**
     * Prueba que no exista un cliente con la misma cedula
     */
    @Test
    public void validarExistenciaClientelTest() {
        // Arrange
        Cliente cliente = new ClienteTestBuilder().build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existe(Mockito.anyString())).thenReturn(true);
        ServicioIngresarCliente servicioIngresarCliente = new ServicioIngresarCliente(repositorioCliente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioIngresarCliente.ejecutar(cliente), ExcepcionDuplicidad.class,"El cliente ya existe en el sistema");
    }

    /**
     * Prueba el ingreso de un cliente a la discoteca
     */
    @Test
    public void validarIngresoClienteTest() {
        // Arrange
        Cliente cliente = new ClienteTestBuilder()
                .setCedula("445566")
                .setGenero("M")
                .setFechaNacimiento(LocalDate.of(2000,2,15))
                .build();
        when(repositorioCliente.existe(anyString())).thenReturn(false);
        when(repositorioCliente.crear(cliente)).thenReturn(1L);
        ServicioIngresarCliente servicioIngresarCliente = new ServicioIngresarCliente(repositorioCliente);
        // Act
        long idSolicitud = servicioIngresarCliente.ejecutar(cliente);
        // Assert
        Assert.assertEquals(1L, idSolicitud);
    }

}
