package com.ceiba.boleto.puerto.repositorio;

import com.ceiba.boleto.modelo.entidad.Boleto;
import com.ceiba.cliente.modelo.entidad.Cliente;

public interface RepositorioBoleto {

    /**
     * Permite crear un voleto
     * @param voleto
     * @return el id generado
     */
    Long crear(Boleto voleto);

    /**
     * Permite eliminar un voleto
     * @param id
     * @return el id generado
     */
    void eliminar(Long id);

    /**
     * Permite obtener un cliente con el id
     * @param id
     * @return el cliente
     */
    Cliente obtenerPorId(Long id);

    boolean exiteConId(Long id);


}
