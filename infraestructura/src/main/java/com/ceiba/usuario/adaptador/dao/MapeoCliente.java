package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoCliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {
    @Override
    public DtoCliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String cedula = resultSet.getString("cedula");
        String genero = resultSet.getString("genero");
        Double precioEntrada = resultSet.getDouble("precio_entrada");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_nacimiento");

        return new DtoCliente(id,nombre,cedula, genero, precioEntrada,fecha);
    }
}
