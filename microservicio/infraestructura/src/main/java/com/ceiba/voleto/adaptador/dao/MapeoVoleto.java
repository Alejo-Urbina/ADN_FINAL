package com.ceiba.voleto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.voleto.modelo.dto.DtoVoleto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoVoleto implements RowMapper<DtoVoleto>, MapperResult {

    @Override
    public DtoVoleto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        double precioEntrada = resultSet.getDouble("precio_entrada");
        LocalDate fechaIngreso = extraerLocalDate(resultSet, "fecha_ingreso");
        Long clienteId = resultSet.getLong("id_cliente");
        return new DtoVoleto(id,precioEntrada,fechaIngreso,clienteId);
    }
}
