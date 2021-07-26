package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.servicio.ServicioEliminarCliente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarCliente  implements ManejadorComando<Long> {
    private final ServicioEliminarCliente servicioEliminarCliente;

    public ManejadorEliminarCliente(ServicioEliminarCliente servicioEliminarCliente) {
        this.servicioEliminarCliente = servicioEliminarCliente;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarCliente.ejecutar(idUsuario);
    }
}
