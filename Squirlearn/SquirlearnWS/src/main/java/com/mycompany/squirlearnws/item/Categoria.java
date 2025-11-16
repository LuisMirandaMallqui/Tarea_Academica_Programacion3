package com.mycompany.squirlearnws.item;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.item.CategoriaDto;
import pe.pucp.edu.squirlearn.business.item.CategoriaBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Categoria")
public class Categoria {

    private CategoriaBo categoriaBo;
    
    public Categoria(){
        this.categoriaBo = new CategoriaBo();
    }
    
    @WebMethod(operationName = "listarTodosCategoria")
    public ArrayList<CategoriaDto> listarTodosCategoria() {
        return this.categoriaBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorIdCategoria")
    public CategoriaDto obtenerPorIdCategoria(@WebParam(name = "id") Integer id) {
        return this.categoriaBo.obtenerPorId(id);
    }

}
