package com.ceiba.voleto.comando.fabrica;

import com.ceiba.usuario.modelo.entidad.Cliente;
import com.ceiba.voleto.comando.ComandoVoleto;
import com.ceiba.voleto.modelo.entidad.Voleto;
import com.ceiba.voleto.puerto.repositorio.RepositorioVoleto;
import org.springframework.stereotype.Component;

@Component
public class FabricaVoleto {

    private final RepositorioVoleto repositorioVoleto;

    public FabricaVoleto(RepositorioVoleto repositorioVoleto) {
        this.repositorioVoleto = repositorioVoleto;
    }

    public Voleto crear(ComandoVoleto comandoVoleto) {
        Cliente cliente = repositorioVoleto.obtenerPorId(comandoVoleto.getClienteId());
        return new Voleto(
                comandoVoleto.getId(),
                comandoVoleto.getPrecioEntrada(),
                comandoVoleto.getFechaIngreso(),
                cliente
        );
    }

}
