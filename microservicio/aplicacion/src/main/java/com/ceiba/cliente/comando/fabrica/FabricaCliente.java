package com.ceiba.cliente.comando.fabrica;

import com.ceiba.cliente.modelo.entidad.Cliente;
import org.springframework.stereotype.Component;

import com.ceiba.cliente.comando.ComandoCliente;

@Component
public class FabricaCliente {

    public Cliente ingresar(ComandoCliente comandoCliente) {
        return new Cliente(
                comandoCliente.getId(),
                comandoCliente.getNombre(),
                comandoCliente.getCedula(),
                comandoCliente.getGenero(),
                comandoCliente.getFechaNacimiento()
        );
    }

}
