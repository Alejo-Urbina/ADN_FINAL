package com.ceiba.usuario.controlador;

import com.ceiba.ApplicationMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorCliente.class)
public class ConsultaControladorClienteTest {

    @Autowired
    private MockMvc mocMvc;

    /**
     * Prueba el correcto funcionamiento del lista de solicitudes
     * */
    @Test
    public void validarListadoClientes() throws Exception {
        // Arrange - Act
        mocMvc.perform(get("/clientes")
                .contentType(MediaType.APPLICATION_JSON))
                // Assert
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[*].nombre", hasItem("Giovy Urbina")))
                .andExpect(jsonPath("$[*].cedula", hasItem("1090515821")))
                .andExpect(jsonPath("$[*].genero", hasItem("M")))
                .andExpect(jsonPath("$[*].fecha_nacimiento", hasItem(LocalDateTime.now())));
    }
}