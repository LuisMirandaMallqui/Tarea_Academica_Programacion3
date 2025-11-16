package com.mycompany.squirlearnws.publicacion;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.publicacion.EstadoPublicacionDto;
import pe.pucp.edu.squirlearn.business.publicacion.EstadoPublicacionBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "EstadoPublicacion")
public class EstadoPublicacion {

    private EstadoPublicacionBo estadoPublicacionBo;
    
    public EstadoPublicacion(){
        this.estadoPublicacionBo = new EstadoPublicacionBo();
    }
    
    @WebMethod(operationName = "listarTodosEstadoPublicacion")
    public ArrayList<EstadoPublicacionDto> listarTodosEstadoPublicacion() {
        return this.estadoPublicacionBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorIdEstadoPublicacion")
    public EstadoPublicacionDto obtenerPorIdEstadoPublicacion(@WebParam(name = "id") Integer id) {
        return this.estadoPublicacionBo.obtenerPorId(id);
    }

}
