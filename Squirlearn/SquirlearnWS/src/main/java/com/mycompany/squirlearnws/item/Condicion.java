package com.mycompany.squirlearnws.item;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.item.CondicionDto;
import pe.pucp.edu.squirlearn.business.item.CondicionBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Condicion")
public class Condicion {

    private CondicionBo condicionBo;
    
    public Condicion(){
        this.condicionBo = new CondicionBo();
    }
    
    @WebMethod(operationName = "listarTodosCondicion")
    public ArrayList<CondicionDto> listarTodosCondicion() {
        return this.condicionBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorIdCondicion")
    public CondicionDto obtenerPorIdCondicion(@WebParam(name = "id") Integer id) {
        return this.condicionBo.obtenerPorId(id);
    }

}
