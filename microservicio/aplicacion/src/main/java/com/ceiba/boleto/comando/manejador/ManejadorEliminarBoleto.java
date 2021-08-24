package com.ceiba.boleto.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.boleto.servicio.ServicioEliminarBoleto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarBoleto implements ManejadorComando<Long> {

    private final ServicioEliminarBoleto servicioEliminarBoleto;

    public ManejadorEliminarBoleto(ServicioEliminarBoleto servicioEliminarVoleto) {
        this.servicioEliminarBoleto = servicioEliminarVoleto;
    }

    public void ejecutar(Long id){
        this.servicioEliminarBoleto.ejecutar(id);
    }

}
