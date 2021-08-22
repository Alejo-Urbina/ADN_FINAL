package com.ceiba.voleto.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.adaptador.dao.MapeoClienteObjeto;
import com.ceiba.usuario.modelo.entidad.Cliente;
import com.ceiba.voleto.modelo.entidad.Voleto;
import com.ceiba.voleto.puerto.repositorio.RepositorioVoleto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioVoletoMysql implements RepositorioVoleto {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "voleto", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "cliente", value = "listarCliente")
    private static String sqlCliente;


    public RepositorioVoletoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Voleto voleto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("precio_entrada", voleto.getPrecioEntrada());
        paramSource.addValue("fecha_ingreso", voleto.getFechaIngreso());
        paramSource.addValue("id_cliente", voleto.getCliente().getId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, paramSource, keyHolder, new String[]{"id"});

        return this.customNamedParameterJdbcTemplate.validarNulo(keyHolder.getKey());
    }

    @Override
    public Cliente obtenerPorId(Long id) {
        return (Cliente) this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlCliente, new MapeoClienteObjeto()).get(0);
    }
}
