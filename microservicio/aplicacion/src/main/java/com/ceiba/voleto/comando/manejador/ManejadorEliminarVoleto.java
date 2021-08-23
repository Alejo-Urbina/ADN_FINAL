package com.ceiba.voleto.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.voleto.servicio.ServicioEliminarVoleto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarVoleto implements ManejadorComando<Long> {

    private final ServicioEliminarVoleto servicioEliminarVoleto;

    public ManejadorEliminarVoleto(ServicioEliminarVoleto servicioEliminarVoleto) {
        this.servicioEliminarVoleto = servicioEliminarVoleto;
    }

    public void ejecutar(Long id){
        this.servicioEliminarVoleto.ejecutar(id);
    }

}
