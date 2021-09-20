package com.ceiba.boleto.adaptador.dao;

import com.ceiba.boleto.adaptador.repositorio.RepositorioBoletoMysql;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.boleto.modelo.entidad.Boleto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoBoletoObjeto implements RowMapper<Boleto>, MapperResult {

    private RepositorioBoletoMysql repositorioBoletoMysql;

    public MapeoBoletoObjeto(RepositorioBoletoMysql repositorioBoletoMysql) {
        this.repositorioBoletoMysql = repositorioBoletoMysql;
    }

    @Override
    public Boleto mapRow(ResultSet resultSet, int reoNum) throws SQLException {
        Long id = resultSet.getLong("id");
        double precioEntrada = resultSet.getDouble("precio_entrada");
        Long clienteId = resultSet.getLong("id_cliente");
        Cliente cliente = repositorioBoletoMysql.obtenerPorId(clienteId);
        return new Boleto(cliente);
    }
}
