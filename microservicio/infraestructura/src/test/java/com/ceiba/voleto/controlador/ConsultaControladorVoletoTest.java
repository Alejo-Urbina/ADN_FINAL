package com.ceiba.voleto.controlador;

import com.ceiba.ApplicationMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorVoleto.class)
public class ConsultaControladorVoletoTest {

    @Autowired
    private MockMvc mocMvc;

    /**
     * Prueba el correcto funcionamiento del GET para listar los voletos
     */
    @Test
    public void validarListadoVoletos() throws Exception {
        // Arrange - Act
        mocMvc.perform(get("/voletos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
