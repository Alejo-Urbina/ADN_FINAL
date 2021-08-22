package com.ceiba.voleto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.voleto.modelo.dto.DtoVoleto;
import com.ceiba.voleto.puerto.dao.DaoVoleto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoVoletoMysql implements DaoVoleto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "voleto", value = "listar")
    private static String sqlListar;

    public DaoVoletoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoVoleto> listar(){
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoVoleto());
    }

}
