package com.ceiba.voleto.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.voleto.modelo.entidad.Voleto;
import com.ceiba.voleto.puerto.repositorio.RepositorioVoleto;

public class ServicioCrearVoleto {

    private final RepositorioVoleto repositorioVoleto;
    private static final String EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA = "El cliente no existe en el sistema";

    public ServicioCrearVoleto(RepositorioVoleto repositorioVoleto) {
        this.repositorioVoleto = repositorioVoleto;
    }

    public Long ejecutar(Voleto voleto){
        voleto.calcularPrecioEntrada();
        System.out.println(voleto.getPrecioEntrada());
        return this.repositorioVoleto.crear(voleto);
    }

    private void validarExistenciaPreviaId(Long id) {
        boolean existe = this.repositorioVoleto.exiteConId(id);
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
