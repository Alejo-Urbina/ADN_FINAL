package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.puerto.repositorio.RepositorioCliente;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ServicioEliminarClienteTest {

    private RepositorioCliente repositorioCliente;

    @Before
    public void InstanciarCliente(){
        repositorioCliente = mock(RepositorioCliente.class);
    }

    /**
     * Prueba que no exista un cliente
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
