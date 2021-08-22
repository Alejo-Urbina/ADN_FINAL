package com.ceiba.voleto.puerto.repositorio;

import com.ceiba.voleto.modelo.entidad.Voleto;
import com.ceiba.usuario.modelo.entidad.Cliente;

public interface RepositorioVoleto {

    /**
     * Permite crear un voleto
     * @param voleto
     * @return el id generado
     */
    Long crear(Voleto voleto);

    /**
     * Permite obtener un cliente con el id
     * @param id
     * @return el cliente
     */
    Cliente obtenerPorId(Long id);

}
