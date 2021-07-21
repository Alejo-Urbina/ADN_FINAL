package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Cliente;
import com.ceiba.usuario.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.servicio.negocio.CalcularPrecioEntrada;
import com.ceiba.usuario.servicio.negocio.PrecioEntrada;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;


public class ServicioIngresarCliente {

    private static final String EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA = "El cliente ya existe en el sistema";
    private static final String EL_CLIENTE_ES_MENOR_DE_EDAD = "El cliente es menor de edad";
    private static final int NUMERO_MAYOR_EDAD = 18;

    private final  RepositorioCliente repositorioCliente;

    public ServicioIngresarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Long ejecutar(Cliente cliente) {
        validarExistenciaPrevia(cliente);
        validarMayorEdad(cliente);
        cliente.setPrecioEntrada(calcularPrecioEntrada(cliente));
        return this.repositorioCliente.crear(cliente);
    }

    private void validarExistenciaPrevia(Cliente cliente) {
        boolean existe = this.repositorioCliente.existe(cliente.getCedula());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarMayorEdad(Cliente cliente){
        boolean mayor = true;
        //Se instancia una variable LocalDate para usar el relacionarlo con Period y asi encontrar su edad
        // exacta restando la actual con la de nacimiento
        LocalDate fechaConLocalDate = LocalDate.of(cliente.getFechaNacimiento().getYear(),
                                                    cliente.getFechaNacimiento().getMonth(),
                                                    cliente.getFechaNacimiento().getDayOfMonth());
        //Se instancia una variable para comparar las dos fechas y asi hallar el tiempo en años, meses y dias del Cliente
        Period edadCliente = Period.between(fechaConLocalDate,LocalDate.now());
        if(edadCliente.getYears() >= NUMERO_MAYOR_EDAD){
            mayor =false;
        }
        if (mayor){
            throw new ExcepcionDuplicidad(EL_CLIENTE_ES_MENOR_DE_EDAD);
        }
    }

    private Double calcularPrecioEntrada(Cliente cliente) {
        CalcularPrecioEntrada calcularPrecioEntrada = null;
        return calcularPrecioEntrada.calcularEntrada(cliente);
    }
}
