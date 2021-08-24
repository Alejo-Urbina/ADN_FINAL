package com.ceiba.boleto.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.cliente.adaptador.dao.MapeoClienteObjeto;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.boleto.modelo.entidad.Boleto;
import com.ceiba.boleto.puerto.repositorio.RepositorioBoleto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioBoletoMysql implements RepositorioBoleto {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "boleto", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "boleto", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "cliente", value = "listarCliente")
    private static String sqlCliente;

    @SqlStatement(namespace="cliente", value="existeConId")
    private static String sqlExisteConId;


    public RepositorioBoletoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Boleto voleto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("precio_entrada", voleto.getPrecioEntrada());
        paramSource.addValue("fecha_ingreso", voleto.getFechaIngreso());
        paramSource.addValue("id_cliente", voleto.getCliente().getId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, paramSource, keyHolder, new String[]{"id"});

        return this.customNamedParameterJdbcTemplate.validarNulo(keyHolder.getKey());
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public Cliente obtenerPorId(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return (Cliente) this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCliente, parameterSource, new MapeoClienteObjeto());
    }

    @Override
    public boolean exiteConId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteConId,paramSource, Boolean.class);
    }

}
