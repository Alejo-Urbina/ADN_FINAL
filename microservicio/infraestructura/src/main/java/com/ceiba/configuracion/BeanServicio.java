package com.ceiba.configuracion;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.cliente.servicio.ServicioIngresarCliente;
import com.ceiba.boleto.puerto.repositorio.RepositorioBoleto;
import com.ceiba.boleto.servicio.ServicioCrearBoleto;
import com.ceiba.boleto.servicio.ServicioEliminarBoleto;
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

    @Bean
    public ServicioCrearBoleto servicioCrearBoleto(RepositorioBoleto repositorioBoleto){
        return new ServicioCrearBoleto(repositorioBoleto);
    }

    @Bean
    public ServicioEliminarBoleto servicioEliminarBoleto(RepositorioBoleto repositorioBoleto) {
        return new ServicioEliminarBoleto(repositorioBoleto);
    }
}
