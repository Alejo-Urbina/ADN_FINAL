package com.ceiba.boleto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.boleto.comando.ComandoBoleto;
import com.ceiba.boleto.comando.manejador.ManejadorCrearBoleto;
import com.ceiba.boleto.comando.manejador.ManejadorEliminarBoleto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boletos")
@Api(tags = {"Controlador comando boletos"})
public class ComandoControladorBoleto {

    private final ManejadorCrearBoleto manejadorCrearBoleto;
    private final ManejadorEliminarBoleto manejadorEliminarBoleto;

    @Autowired
    public ComandoControladorBoleto(ManejadorCrearBoleto manejadorCrearBoleto, ManejadorEliminarBoleto manejadorEliminarBoleto) {
        this.manejadorCrearBoleto = manejadorCrearBoleto;
        this.manejadorEliminarBoleto = manejadorEliminarBoleto;
    }

    @PostMapping
    @ApiOperation("Crear boleto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoBoleto comandoBoleto){
        return manejadorCrearBoleto.ejecutar(comandoBoleto);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar boleto")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarBoleto.ejecutar(id);
    }

}
