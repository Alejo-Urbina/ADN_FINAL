package com.ceiba.cliente.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.cliente.modelo.entidad.Cliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoClienteObjeto implements RowMapper<Cliente>, MapperResult {
    @Override
    public Cliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String cedula = resultSet.getString("cedula");
        String genero = resultSet.getString("genero");
        LocalDate fecha = extraerLocalDate(resultSet, "fecha_nacimiento");

        return new Cliente(id,nombre,cedula, genero, fecha);
    }
}
