package com.ceiba.usuario.servicio.negocio;

import com.ceiba.usuario.modelo.entidad.Cliente;

@FunctionalInterface
public interface CalcularPrecioEntrada {
    Double calcularEntrada(Cliente cliente);
}
