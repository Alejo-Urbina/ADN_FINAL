package com.ceiba.voleto.servicio;

import com.ceiba.voleto.modelo.entidad.Voleto;
import com.ceiba.voleto.puerto.repositorio.RepositorioVoleto;

public class ServicioCrearVoleto {

    private final RepositorioVoleto repositorioVoleto;


    public ServicioCrearVoleto(RepositorioVoleto repositorioVoleto) {
        this.repositorioVoleto = repositorioVoleto;
    }

    public Long ejecutar(Voleto voleto){
        voleto.calcularPrecioEntrada();
        System.out.println(voleto.getPrecioEntrada());
        return this.repositorioVoleto.crear(voleto);
    }
}
