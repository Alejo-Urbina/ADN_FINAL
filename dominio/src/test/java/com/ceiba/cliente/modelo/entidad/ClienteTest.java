package com.ceiba.cliente.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.builder.ClienteTestBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

    private static final String NOMBRE_CLIENTE_REQUERIDO = "Se debe diligenciar el nombre del cliente";
    private static final String CEDULA_CLIENTE_REQUERIDO = "Se debe diligenciar la cedula del cliente";
    private static final String GENERO_CLIENTE_REQUERIDO = "Se debe diligenciar el genero del solicitante";
    private static final String FECHA_CLIENTE_REQUERIDO = "Se debe diligenciar la fecha de nacimiento del solicitante";

    private ClienteTestBuilder clienteTestBuilder;

    @Before
    public void setUp(){clienteTestBuilder = new ClienteTestBuilder();}

    @Test
    public void validarNombreClienteRequerido(){
        // Arrange
        clienteTestBuilder.setNombre(null);
        // Act - Assert
        BasePrueba.assertThrows(clienteTestBuilder::build, ExcepcionValorObligatorio.class, NOMBRE_CLIENTE_REQUERIDO);
    }

    @Test
    public void validarCedulaClienteRequurido(){
        // Arrange
        clienteTestBuilder.setCedula(null);
        // Act - Assert
        BasePrueba.assertThrows(clienteTestBuilder::build, ExcepcionValorObligatorio.class, CEDULA_CLIENTE_REQUERIDO);
    }
}
