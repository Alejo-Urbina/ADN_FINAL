package com.ceiba.cliente.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioCliente;
import com.ceiba.usuario.servicio.ServicioEliminarCliente;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ServicioEliminarClienteTest {

    private RepositorioCliente repositorioCliente;

    @Before
    public void InstanciarCliente(){
        repositorioCliente = mock(RepositorioCliente.class);
    }

    /**
     * Prueba que valida que se implemente el método eliminar del repositorio
     */
    @Test
    public void validarEliminarClienteTest() {
        // Arrange
        ServicioEliminarCliente servicioEliminarCliente = new ServicioEliminarCliente(repositorioCliente);
        // Act
        servicioEliminarCliente.ejecutar(anyLong());
        // Assert
        verify(repositorioCliente).eliminar(anyLong());
    }

}
