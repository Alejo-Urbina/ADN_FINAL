package com.ceiba.voleto.controlador;


import com.ceiba.voleto.consulta.ManejadorListarVoleto;
import com.ceiba.voleto.modelo.dto.DtoVoleto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/voletos")
@Api(tags = {"Controlador consulta voletos"})
public class ConsultaControladorVoleto {

    private final ManejadorListarVoleto manejadorListarVoleto;

    public ConsultaControladorVoleto(ManejadorListarVoleto manejadorListarVoleto) {
        this.manejadorListarVoleto = manejadorListarVoleto;
    }

    @GetMapping
    @ApiOperation("Listar voletos")
    public List<DtoVoleto> listar() {
        return this.manejadorListarVoleto.ejecutar();
    }

}
