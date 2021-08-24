package com.ceiba.boleto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.boleto.modelo.dto.DtoBoleto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoBoleto implements RowMapper<DtoBoleto>, MapperResult {

    @Override
    public DtoBoleto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        double precioEntrada = resultSet.getDouble("precio_entrada");
        LocalDate fechaIngreso = extraerLocalDate(resultSet, "fecha_ingreso");
        Long clienteId = resultSet.getLong("id_cliente");
        return new DtoBoleto(id,precioEntrada,fechaIngreso,clienteId);
    }
}
