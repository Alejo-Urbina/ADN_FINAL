package com.ceiba.dominio.excepcion;

public class ExcepcionMayorEdad extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionMayorEdad(String mensaje){super(mensaje);}
}
