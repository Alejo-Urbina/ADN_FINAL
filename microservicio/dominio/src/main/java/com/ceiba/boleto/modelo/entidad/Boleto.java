package com.ceiba.boleto.modelo.entidad;


import com.ceiba.boleto.constante.TipoGenero;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.boleto.constante.DiaFinDeSemana;
import com.ceiba.dominio.ValidadorArgumento;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Boleto {

    private static final String SE_DEBE_INGRESAR_EL_ID_CLIENTE = "Se debe ingresar el id del cliente";

    private Long id;
    private double precioEntrada;
    private LocalDate fechaIngreso;
    private Cliente cliente;

    private static final Double PRECIO_ENTRADA_HOMBRE = 15000d;
    private static final Double PRECIO_ENTRADA_MUJER = 10000d;
    private static final Double TASA_AUMENTO_SADADO_O_DOMINGO = 0.05d;
    private static final Double PRECIO_ENTRADA_CUMPLEANERO = 0d;



    public Boleto(Cliente cliente) {
        ValidadorArgumento.validarObligatorio(cliente,SE_DEBE_INGRESAR_EL_ID_CLIENTE);

        this.cliente = cliente;
        this.fechaIngreso = LocalDate.now();
    }

    public void calcularPrecioEntrada() {
        calcularPrecioPorGenero();
        sumarleSiEsSabadoODomingo();
        cumpleanosCliente();
    }

    private void calcularPrecioPorGenero(){
        if(this.cliente.getGenero().equals(TipoGenero.H.toString())){
            this.precioEntrada = PRECIO_ENTRADA_HOMBRE;
        } else {
            if (this.cliente.getGenero().equals(TipoGenero.M.toString())){
                this.precioEntrada = PRECIO_ENTRADA_MUJER;
            }
        }
    }

    private void sumarleSiEsSabadoODomingo(){
        if (String.valueOf(this.fechaIngreso.getDayOfWeek()).equals(DiaFinDeSemana.SATURDAY.toString()) ||
                String.valueOf(this.fechaIngreso.getDayOfWeek()).equals(DiaFinDeSemana.SUNDAY.toString())) {
            this.precioEntrada = (this.precioEntrada + (this.precioEntrada * TASA_AUMENTO_SADADO_O_DOMINGO));
        }
    }

    private void cumpleanosCliente() {
        if (this.cliente.getFechaNacimiento().getMonth() == this.fechaIngreso.getMonth() &&
                this.cliente.getFechaNacimiento().getDayOfMonth() == this.fechaIngreso.getDayOfMonth()){
            this.precioEntrada = PRECIO_ENTRADA_CUMPLEANERO;
        }
    }

}
