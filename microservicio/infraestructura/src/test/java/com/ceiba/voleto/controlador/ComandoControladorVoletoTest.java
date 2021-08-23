package com.ceiba.voleto.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.voleto.builder.ComandoVoletoTestDataBuilder;
import com.ceiba.voleto.comando.ComandoVoleto;
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
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorVoleto.class)
public class ComandoControladorVoletoTest {

    private static final String direccion = "/voletos";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    /**
     * Prueba que el servicio POST funcione correctamente
     */
    @Test
    public void validarCrearVoleto() throws Exception {

        // arrange
        ComandoVoleto voleto = new ComandoVoletoTestDataBuilder().build();
        System.out.println(voleto.getClienteId());

        // act - assert
        mocMvc.perform(post(direccion)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(voleto)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    /**
     * Prueba que el servicio de DELETE funcione correctamente
     */
    @Test
    public void validarEliminacionVoleto() throws Exception {
        // Arrange
        Long id = 1L;
        // Act
        mocMvc.perform(delete(direccion.concat("/{id}"), id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                // Assert
                .andExpect(status().isOk());
    }

}
