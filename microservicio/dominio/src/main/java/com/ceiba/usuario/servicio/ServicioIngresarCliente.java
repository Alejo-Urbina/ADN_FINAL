package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionMayorEdad;
import com.ceiba.usuario.constante.DiaFinDeSemana;
import com.ceiba.usuario.constante.TipoGenero;
import com.ceiba.usuario.modelo.entidad.Cliente;
import com.ceiba.usuario.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import java.time.LocalDate;
import java.time.Period;


public class ServicioIngresarCliente {

    private static final String EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA = "El cliente ya existe en el sistema";
    private static final String EL_CLIENTE_ES_MENOR_DE_EDAD = "El cliente es menor de edad";
    private static final int NUMERO_MAYOR_EDAD = 18;
    private static final Double PRECIO_ENTRADA_HOMBRE = 15000d;
    private static final Double PRECIO_ENTRADA_MUJER = 10000d;
    private static final Double TASA_AUMENTO_SADADO_O_DOMINGO = 0.05d;

    private final  RepositorioCliente repositorioCliente;

    public ServicioIngresarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Long ejecutar(Cliente cliente) {
        validarExistenciaPrevia(cliente);
        validarMayorEdad(cliente);
        calcularPrecioEntrada(cliente);
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
            throw new ExcepcionMayorEdad(EL_CLIENTE_ES_MENOR_DE_EDAD);
        }
    }

    private void calcularPrecioEntrada(Cliente cliente) {
        //El metodo nos ayuda a mirar si es hombre vale una cifra, si es mujer otra sifra
        if(cliente.getGenero().equals(TipoGenero.H.toString())){
            cliente.setPrecioEntrada(PRECIO_ENTRADA_HOMBRE);
        } else {
            if (cliente.getGenero().equals(TipoGenero.M.toString())){
                cliente.setPrecioEntrada(PRECIO_ENTRADA_MUJER);
            }
        }
        //Miranmos la fecha del dia de hoy y si es sabado o domingo se sube un 5%
        if (String.valueOf(LocalDate.now().getDayOfWeek()).equals(DiaFinDeSemana.SATURDAY.toString()) ||
                String.valueOf(LocalDate.now().getDayOfWeek()).equals(DiaFinDeSemana.SUNDAY.toString())) {
            cliente.setPrecioEntrada(cliente.getPrecioEntrada() + (cliente.getPrecioEntrada() * TASA_AUMENTO_SADADO_O_DOMINGO));
        }
        if (cumpleanosCliente(cliente)){
            cliente.setPrecioEntrada(0d);
        }
    }

    private boolean cumpleanosCliente(Cliente cliente) {
        return (cliente.getFechaNacimiento().getMonth() == LocalDate.now().getMonth() &&
                cliente.getFechaNacimiento().getDayOfMonth() == LocalDate.now().getDayOfMonth());
    }
}
