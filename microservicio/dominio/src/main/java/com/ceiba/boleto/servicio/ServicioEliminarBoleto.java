package com.ceiba.boleto.servicio;

import com.ceiba.boleto.puerto.repositorio.RepositorioBoleto;

public class ServicioEliminarBoleto {

    private final RepositorioBoleto repositorioBoleto;

    public ServicioEliminarBoleto(RepositorioBoleto repositorioBoleto) {
        this.repositorioBoleto = repositorioBoleto;
    }

    public void ejecutar(Long id){
        this.repositorioBoleto.eliminar(id);
    }

}
