package com.ceiba.cliente.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.manejador.ManejadorIngresarCliente;
import com.ceiba.cliente.comando.manejador.ManejadorEliminarCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
@Api(tags = { "Controlador comando cliente"})
public class ComandoControladorCliente {
    private final ManejadorIngresarCliente manejadorIngresarCliente;
    private final ManejadorEliminarCliente manejadorEliminarCliente;

    @Autowired
    public ComandoControladorCliente(ManejadorIngresarCliente manejadorIngresarCliente, ManejadorEliminarCliente manejadorEliminarCliente) {
        this.manejadorIngresarCliente = manejadorIngresarCliente;
        this.manejadorEliminarCliente = manejadorEliminarCliente;
    }

    @PostMapping
    @ApiOperation("Crear Cliente")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCliente comandoCliente) {
        return manejadorIngresarCliente.ejecutar(comandoCliente);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Cliente")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarCliente.ejecutar(id);
    }
}
