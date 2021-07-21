package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoCliente;
import com.ceiba.usuario.comando.fabrica.FabricaCliente;
import com.ceiba.usuario.modelo.entidad.Cliente;
import com.ceiba.usuario.servicio.ServicioIngresarCliente;
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
