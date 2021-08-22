package com.ceiba.voleto.consulta;

import com.ceiba.voleto.modelo.dto.DtoVoleto;
import com.ceiba.voleto.puerto.dao.DaoVoleto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarVoleto {

    private final DaoVoleto daoVoleto;


    public ManejadorListarVoleto(DaoVoleto daoVoleto) {
        this.daoVoleto = daoVoleto;
    }

    public List<DtoVoleto> ejecutar(){
        return this.daoVoleto.listar();
    }
}
