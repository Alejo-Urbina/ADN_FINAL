package com.ceiba.boleto.controlador;

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
@WebMvcTest(ConsultaControladorBoleto.class)
public class ConsultaControladorBoletoTest {

    @Autowired
    private MockMvc mocMvc;

    /**
     * Prueba el correcto funcionamiento del GET para listar los boletos
     */
    @Test
    public void validarListadoBoletos() throws Exception {
        // Arrange - Act
        mocMvc.perform(get("/boletos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
