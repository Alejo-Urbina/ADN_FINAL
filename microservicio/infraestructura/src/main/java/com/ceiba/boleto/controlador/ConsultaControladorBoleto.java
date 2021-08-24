package com.ceiba.boleto.controlador;

import com.ceiba.boleto.consulta.ManejadorListarBoleto;
import com.ceiba.boleto.modelo.dto.DtoBoleto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boletos")
@Api(tags = {"Controlador consulta boletos"})
public class ConsultaControladorBoleto {

    private final ManejadorListarBoleto manejadorListarBoleto;

    public ConsultaControladorBoleto(ManejadorListarBoleto manejadorListarBoleto) {
        this.manejadorListarBoleto = manejadorListarBoleto;
    }

    @GetMapping
    @ApiOperation("Listar boletos")
    public List<DtoBoleto> listar() {
        return this.manejadorListarBoleto.ejecutar();
    }

}
