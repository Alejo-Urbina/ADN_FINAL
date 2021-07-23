package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.builder.ClienteTestBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Cliente;
import com.ceiba.usuario.puerto.repositorio.RepositorioCliente;
import com.ceiba.usuario.servicio.ServicioIngresarCliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class ServicioCrearClienteTest {

    public static final String YA_EXISTE_CLIENTE = "Ya existe el cliente registrado";

    private RepositorioCliente repositorioCliente;

    @Before
    public void instanciarObjeto(){
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
     * Prueba la creación de una solicitud manipulando exitosamente los retornos del repositorio
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
