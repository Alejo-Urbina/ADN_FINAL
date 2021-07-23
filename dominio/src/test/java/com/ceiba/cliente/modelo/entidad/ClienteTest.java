package com.ceiba.cliente.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.builder.ClienteTestBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ClienteTest {

    private static final String NOMBRE_CLIENTE_REQUERIDO = "Se debe diligenciar el nombre del cliente";
    private static final String CEDULA_CLIENTE_REQUERIDO = "Se debe diligenciar la cedula del cliente";
    private static final String GENERO_CLIENTE_REQUERIDO = "Se debe diligenciar el genero del solicitante";
    private static final String FECHA_CLIENTE_REQUERIDO = "Se debe diligenciar la fecha de nacimiento del solicitante";

    private ClienteTestBuilder clienteTestBuilder;

    @Before
    public void instanciarObjeto(){clienteTestBuilder = new ClienteTestBuilder();}

    @Test
    public void validarNombreClienteVacio(){
        // Arrange
        clienteTestBuilder.setNombre(null);
        // Act - Assert
        assertNull(clienteTestBuilder.getNombre());
    }

    @Test
    public void validarCedulaClienteRequerido(){
        clienteTestBuilder.setCedula(null);
        // Act - Assert
        assertNull(clienteTestBuilder.getCedula());
    }

    @Test
    public void validarGeneroClienteRequerido(){
        clienteTestBuilder.setGenero(null);
        // Act - Assert
        assertNull(clienteTestBuilder.getGenero());
    }

    @Test
    public void validarFechaClienteRequerido(){
        clienteTestBuilder.setFechaNacimiento(null);
        // Act - Assert
        assertNull(clienteTestBuilder.getFechaNacimiento());
    }

    @Test
    public void validarPrecioEntradaClienteRequerido(){
        clienteTestBuilder.setPrecioEntrada(null);
        // Act - Assert
        assertNull(clienteTestBuilder.getPrecioEntrada());
    }
}
