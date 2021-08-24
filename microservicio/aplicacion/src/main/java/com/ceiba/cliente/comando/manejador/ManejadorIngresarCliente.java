package com.ceiba.cliente.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioIngresarCliente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorIngresarCliente implements ManejadorComandoRespuesta<ComandoCliente, ComandoRespuesta<Long>> {

    private final FabricaCliente fabricaCliente;
    private final ServicioIngresarCliente servicioIngresarCliente;

    public ManejadorIngresarCliente(FabricaCliente fabricaCliente, ServicioIngresarCliente servicioIngresarCliente) {
        this.fabricaCliente = fabricaCliente;
        this.servicioIngresarCliente = servicioIngresarCliente;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoCliente comandoCliente) {
        Cliente cliente = this.fabricaCliente.ingresar(comandoCliente);
        return new ComandoRespuesta<>(this.servicioIngresarCliente.ejecutar(cliente));
    }
}
