package com.ceiba.boleto.servicio;

import com.ceiba.boleto.modelo.entidad.Boleto;
import com.ceiba.boleto.puerto.repositorio.RepositorioBoleto;

public class ServicioCrearBoleto {

    private final RepositorioBoleto repositorioBoleto;


    public ServicioCrearBoleto(RepositorioBoleto repositorioBoleto) {
        this.repositorioBoleto = repositorioBoleto;
    }

    public Long ejecutar(Boleto voleto){
        voleto.calcularPrecioEntrada();
        return this.repositorioBoleto.crear(voleto);
    }
}
