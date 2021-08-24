package com.ceiba.boleto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.boleto.modelo.dto.DtoBoleto;
import com.ceiba.boleto.puerto.dao.DaoBoleto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoBoletoMysql implements DaoBoleto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "boleto", value = "listar")
    private static String sqlListar;

    public DaoBoletoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoBoleto> listar(){
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoBoleto());
    }

}
