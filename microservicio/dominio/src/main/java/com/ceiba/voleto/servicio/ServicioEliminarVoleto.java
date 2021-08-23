package com.ceiba.voleto.servicio;

import com.ceiba.voleto.puerto.repositorio.RepositorioVoleto;

public class ServicioEliminarVoleto {

    private final RepositorioVoleto repositorioVoleto;

    public ServicioEliminarVoleto(RepositorioVoleto repositorioVoleto) {
        this.repositorioVoleto = repositorioVoleto;
    }

    public void ejecutar(Long id){
        this.repositorioVoleto.eliminar(id);
    }

}
