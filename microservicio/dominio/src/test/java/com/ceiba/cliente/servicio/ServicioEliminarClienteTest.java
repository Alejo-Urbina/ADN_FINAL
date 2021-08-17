package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.builder.ClienteTestBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Cliente;
import com.ceiba.usuario.puerto.repositorio.RepositorioCliente;
import com.ceiba.usuario.servicio.ServicioEliminarCliente;
import com.ceiba.usuario.servicio.ServicioIngresarCliente;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class ServicioEliminarClienteTest {

    private RepositorioCliente repositorioCliente;

    @Before
    public void InstanciarCliente(){
        repositorioCliente = mock(RepositorioCliente.class);
    }

    /**
     * Prueba que no exista un cliente con la misma cedula
     */
    @Test
    public void validarNoExistenciaClienteTest() {
        // Arrange
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existeConId(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarCliente servicioEliminarCliente = new ServicioEliminarCliente(repositorioCliente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarCliente.ejecutar(1L), ExcepcionDuplicidad.class,"El cliente no existe en el sistema");
    }

}
