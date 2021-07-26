package com.ceiba.cliente.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.builder.ClienteTestBuilder;
import com.ceiba.dominio.excepcion.ExcepcionMayorEdad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.modelo.entidad.Cliente;
import com.ceiba.usuario.puerto.repositorio.RepositorioCliente;
import com.ceiba.usuario.servicio.ServicioIngresarCliente;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClienteTest {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE = "Se debe ingresar el nombre del cliente";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cedula del cliente";
    private static final String SE_DEBE_INGRESAR_EL_GENERO = "Se debe ingresar el genero del cliente";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO = "Se debe ingresar la fecha de nacimiento del cliente";

    private ClienteTestBuilder clienteTestBuilder;
    private RepositorioCliente repositorioCliente;


    @Before
    public void instanciarObjeto(){
        clienteTestBuilder = new ClienteTestBuilder();
        repositorioCliente =mock(RepositorioCliente.class);
    }

    @Test
    public void validarExcepcionNombreTest() {
        // Arrange
        clienteTestBuilder.setNombre(null);
        // Act - Assert
        BasePrueba.assertThrows(clienteTestBuilder::build, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE);
    }

    @Test
    public void validarExcepcionCedulaTest() {
        // Arrange
        clienteTestBuilder.setCedula(null);
        // Act - Assert
        BasePrueba.assertThrows(clienteTestBuilder::build, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_CEDULA);
    }

    @Test
    public void validarExcepcionGeneroTest() {
        // Arrange
        clienteTestBuilder.setGenero(null);
        // Act - Assert
        BasePrueba.assertThrows(clienteTestBuilder::build, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_GENERO);
    }

    @Test
    public void validarExcepcionFechaNacimientoTest() {
        // Arrange
        clienteTestBuilder.setFechaNacimiento(null);
        // Act - Assert
        BasePrueba.assertThrows(clienteTestBuilder::build, ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO);
    }
}
