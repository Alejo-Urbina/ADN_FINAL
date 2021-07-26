package com.ceiba.cliente.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cliente.builder.ComandoClienteTestDataBuilder;
import com.ceiba.usuario.comando.ComandoCliente;
import com.ceiba.usuario.controlador.ComandoControladorCliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorCliente.class)
public class ComandoControladorClienteTest {

    private static final String direccion = "/clientes";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    /**
     * Prueba que el servicio de DELETE funcione correctamente
     */
    @Test
    public void validarEliminacionCliente() throws Exception {
        // Arrange
        Long id = 2L;
        // Act
        mocMvc.perform(delete(direccion.concat("/{id}"), id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                // Assert
                .andExpect(status().isOk());
    }

    /**
     * Prueba que el servicio POST funcione correctamente
     */
    @Test
    public void validaringresarCliente() throws Exception{
        // arrange
        ComandoCliente cliente = new ComandoClienteTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

}
