package com.mycompany.squirlearnws.item;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.item.EstadoItemDto;
import pe.pucp.edu.squirlearn.business.item.EstadoItemBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "EstadoItem")
public class EstadoItem {

    private EstadoItemBo estadoItemBo;
    
    public EstadoItem(){
        this.estadoItemBo = new EstadoItemBo();
    }
    
    @WebMethod(operationName = "listarTodosEstadoItem")
    public ArrayList<EstadoItemDto> listarTodosEstadoItem() {
        return this.estadoItemBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorIdEstadoItem")
    public EstadoItemDto obtenerPorIdEstadoItem(@WebParam(name = "id") Integer id) {
        return this.estadoItemBo.obtenerPorId(id);
    }

}
