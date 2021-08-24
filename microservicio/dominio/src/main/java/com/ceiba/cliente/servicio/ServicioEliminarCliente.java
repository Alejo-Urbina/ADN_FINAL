package com.ceiba.cliente.servicio;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioEliminarCliente {
    private final RepositorioCliente repositorioCliente;
    private static final String EL_CLIENTE__NO_EXISTE_EN_EL_SISTEMA = "El cliente no existe en el sistema";

    public ServicioEliminarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Long id) {
        validarExistenciaPreviaId(id);
        this.repositorioCliente.eliminar(id);
    }

    private void validarExistenciaPreviaId(Long id) {
        boolean existe = this.repositorioCliente.existeConId(id);
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_CLIENTE__NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
