package com.ceiba.voleto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.entidad.Cliente;
import com.ceiba.voleto.adaptador.repositorio.RepositorioVoletoMysql;
import com.ceiba.voleto.modelo.entidad.Voleto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoVoletoObjeto implements RowMapper<Voleto>, MapperResult {

    private RepositorioVoletoMysql repositorioVoletoMysql;

    public MapeoVoletoObjeto(RepositorioVoletoMysql repositorioVoletoMysql) {
        this.repositorioVoletoMysql = repositorioVoletoMysql;
    }

    @Override
    public Voleto mapRow(ResultSet resultSet, int reoNum) throws SQLException {
        Long id = resultSet.getLong("id");
        double precioEntrada = resultSet.getDouble("precio_entrada");
        LocalDate fechaIngreso = extraerLocalDate(resultSet, "fecha_ingreso");
        Long clienteId = resultSet.getLong("id_cliente");
        Cliente cliente = repositorioVoletoMysql.obtenerPorId(clienteId);
        return new Voleto(id,precioEntrada,fechaIngreso,cliente);
    }
}
