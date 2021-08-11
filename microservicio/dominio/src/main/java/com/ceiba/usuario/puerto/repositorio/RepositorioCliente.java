package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Cliente;

public interface RepositorioCliente {
    /**
     * Permite crear un usuario
     * @param cliente
     * @return el id generado
     */
    Long crear(Cliente cliente);

    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param cedula
     * @return si existe o no
     */
    boolean existe(String cedula);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param id
     * @return si existe o no
     */
    boolean existeConId(Long id);
}
