package com.mycompany.squirlearnws.persona;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.persona.RolPersonaDto;
import pe.pucp.edu.squirlearn.business.persona.RolPersonaBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "RolPersona")
public class RolPersona {

    private RolPersonaBo rolPersonaBo;
    
    public RolPersona(){
        this.rolPersonaBo = new RolPersonaBo();
    }
    
    @WebMethod(operationName = "listarTodosRolPersona")
    public ArrayList<RolPersonaDto> listarTodosRolPersona() {
        return this.rolPersonaBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorIdRolPersona")
    public RolPersonaDto obtenerPorIdRolPersona(@WebParam(name = "id") Integer id) {
        return this.rolPersonaBo.obtenerPorId(id);
    }

}
