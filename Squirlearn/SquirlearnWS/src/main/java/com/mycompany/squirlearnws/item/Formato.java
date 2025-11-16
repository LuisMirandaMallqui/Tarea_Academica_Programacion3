package com.mycompany.squirlearnws.item;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.item.FormatoDto;
import pe.pucp.edu.squirlearn.business.item.FormatoBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Formato")
public class Formato {

    private FormatoBo formatoBo;
    
    public Formato(){
        this.formatoBo = new FormatoBo();
    }
    
    @WebMethod(operationName = "listarTodosFormato")
    public ArrayList<FormatoDto> listarTodosFormato() {
        return this.formatoBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorIdFormato")
    public FormatoDto obtenerPorIdFormato(@WebParam(name = "id") Integer id) {
        return this.formatoBo.obtenerPorId(id);
    }

}
