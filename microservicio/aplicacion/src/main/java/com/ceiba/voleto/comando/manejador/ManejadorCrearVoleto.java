package com.ceiba.voleto.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.voleto.comando.ComandoVoleto;
import com.ceiba.voleto.comando.fabrica.FabricaVoleto;
import com.ceiba.voleto.modelo.entidad.Voleto;
import com.ceiba.voleto.servicio.ServicioCrearVoleto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearVoleto implements ManejadorComandoRespuesta<ComandoVoleto,ComandoRespuesta<Long>> {

    private final FabricaVoleto fabricaVoleto;
    private final ServicioCrearVoleto servicioCrearVoleto;

    public ManejadorCrearVoleto(FabricaVoleto fabricaVoleto, ServicioCrearVoleto servicioCrearVoleto) {
        this.fabricaVoleto = fabricaVoleto;
        this.servicioCrearVoleto = servicioCrearVoleto;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoVoleto comandoVoleto){
        Voleto voleto = this.fabricaVoleto.crear(comandoVoleto);
        return new ComandoRespuesta<>(this.servicioCrearVoleto.ejecutar(voleto));
    }

}
