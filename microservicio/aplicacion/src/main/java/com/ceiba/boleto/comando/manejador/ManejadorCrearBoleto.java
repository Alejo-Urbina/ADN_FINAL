package com.ceiba.boleto.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.boleto.comando.ComandoBoleto;
import com.ceiba.boleto.comando.fabrica.FabricaBoleto;
import com.ceiba.boleto.modelo.entidad.Boleto;
import com.ceiba.boleto.servicio.ServicioCrearBoleto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearBoleto implements ManejadorComandoRespuesta<ComandoBoleto,ComandoRespuesta<Long>> {

    private final FabricaBoleto fabricaBoleto;
    private final ServicioCrearBoleto servicioCrearBoleto;

    public ManejadorCrearBoleto(FabricaBoleto fabricaBoleto, ServicioCrearBoleto servicioCrearBoleto) {
        this.fabricaBoleto = fabricaBoleto;
        this.servicioCrearBoleto = servicioCrearBoleto;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoBoleto comandoBoleto){
        Boleto boleto = this.fabricaBoleto.crear(comandoBoleto);
        return new ComandoRespuesta<>(this.servicioCrearBoleto.ejecutar(boleto));
    }

}
