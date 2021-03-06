package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioCliente;
import com.ceiba.usuario.servicio.ServicioEliminarCliente;
import com.ceiba.usuario.servicio.ServicioIngresarCliente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioIngresarCliente servicioCrearCliente(RepositorioCliente repositorioCliente) {
        return new ServicioIngresarCliente(repositorioCliente);
    }

    @Bean
    public ServicioEliminarCliente servicioEliminarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioEliminarCliente(repositorioCliente);
    }
}
