package com.ceiba.boleto.comando.fabrica;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.boleto.comando.ComandoBoleto;
import com.ceiba.boleto.modelo.entidad.Boleto;
import com.ceiba.boleto.puerto.repositorio.RepositorioBoleto;
import org.springframework.stereotype.Component;

@Component
public class FabricaBoleto {

    private final RepositorioBoleto repositorioBoleto;

    public FabricaBoleto(RepositorioBoleto repositorioBoleto) {
        this.repositorioBoleto = repositorioBoleto;
    }

    public Boleto crear(ComandoBoleto comandoVoleto) {
        Cliente cliente = repositorioBoleto.obtenerPorId(comandoVoleto.getClienteId());
        return new Boleto(
                comandoVoleto.getId(),
                comandoVoleto.getPrecioEntrada(),
                cliente
        );
    }

}
