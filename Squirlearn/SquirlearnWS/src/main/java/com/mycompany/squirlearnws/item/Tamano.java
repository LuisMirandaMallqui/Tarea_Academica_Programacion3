package com.mycompany.squirlearnws.item;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.item.TamanoDto;
import pe.pucp.edu.squirlearn.business.item.TamanoBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Tamano")
public class Tamano {

    private TamanoBo tamanoBo;
    
    public Tamano(){
        this.tamanoBo= new TamanoBo();
    }
    
    @WebMethod(operationName = "listarTodosTamano")
    public ArrayList<TamanoDto> listarTodosTamano() {
        return this.tamanoBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorIdTamano")
    public TamanoDto obtenerPorIdTamano(@WebParam(name = "id") Integer id) {
        return this.tamanoBo.obtenerPorId(id);
    }

}
