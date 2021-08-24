package com.ceiba.boleto.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.boleto.builder.ComandoBoletoTestDataBuilder;
import com.ceiba.boleto.comando.ComandoBoleto;
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
@WebMvcTest(ComandoControladorBoleto.class)
public class ComandoControladorBoletoTest {

    private static final String direccion = "/boletos";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    /**
     * Prueba que el servicio POST funcione correctamente
     */
    @Test
    public void validarCrearBoleto() throws Exception {

        // arrange
        ComandoBoleto voleto = new ComandoBoletoTestDataBuilder().build();
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
    public void validarEliminacionBoleto() throws Exception {
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
