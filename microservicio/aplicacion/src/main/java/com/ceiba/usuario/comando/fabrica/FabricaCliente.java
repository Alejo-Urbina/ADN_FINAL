package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.modelo.entidad.Cliente;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoCliente;

@Component
public class FabricaCliente {

    public Cliente ingresar(ComandoCliente comandoCliente) {
        return new Cliente(
                comandoCliente.getId(),
                comandoCliente.getNombre(),
                comandoCliente.getCedula(),
                comandoCliente.getGenero(),
                comandoCliente.getPrecioEntrada(),
                comandoCliente.getFechaNacimiento()
        );
    }

}
