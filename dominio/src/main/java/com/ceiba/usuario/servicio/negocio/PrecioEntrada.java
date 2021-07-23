package com.ceiba.usuario.servicio.negocio;

import com.ceiba.usuario.modelo.entidad.Cliente;

import java.time.LocalDateTime;

public class PrecioEntrada implements  CalcularPrecioEntrada{

    private static final Double PRECIO_ENTRADA_HOMBRE = 15000d;
    private static final Double PRECIO_ENTRADA_MUJER = 10000d;
    private static final String HOMBRE = "H";
    private static final String MUJER = "M";
    private static final String SABADO = "SATURDAY";
    private static final String DOMINGO = "SUNDAY";
    private static final Double TASA_AUMENTO_SADADO_O_DOMINGO = 0.05d;

    private PrecioEntrada() {
        throw new IllegalStateException("Fabrica de estrategias de CalcularInteresCredito");
    }

    @Override
    public Double calcularEntrada(Cliente cliente) {
        if(cliente.getGenero() == HOMBRE){
            cliente.setPrecioEntrada(PRECIO_ENTRADA_HOMBRE);
        } else {
            if (cliente.getGenero() == MUJER){
                cliente.setPrecioEntrada(PRECIO_ENTRADA_MUJER);
            }
        }
        if (String.valueOf(LocalDateTime.now().getDayOfWeek()) == SABADO ||
                String.valueOf(LocalDateTime.now().getDayOfWeek()) == DOMINGO) {
            cliente.setPrecioEntrada(cliente.getPrecioEntrada() + (cliente.getPrecioEntrada() * TASA_AUMENTO_SADADO_O_DOMINGO));
        }
        return cliente.getPrecioEntrada();
    }
}
