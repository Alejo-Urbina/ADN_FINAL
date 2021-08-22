package com.ceiba.voleto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.voleto.comando.ComandoVoleto;
import com.ceiba.voleto.comando.manejador.ManejadorCrearVoleto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voletos")
@Api(tags = {"Controlador comando voletos"})
public class ComandoControladorVoleto {

    private final ManejadorCrearVoleto manejadorCrearVoleto;

    @Autowired
    public ComandoControladorVoleto(ManejadorCrearVoleto manejadorCrearVoleto) {
        this.manejadorCrearVoleto = manejadorCrearVoleto;
    }

    @PostMapping
    @ApiOperation("Crear voleto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoVoleto comandoVoleto){
        return manejadorCrearVoleto.ejecutar(comandoVoleto);
    }

}
