/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.persona;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.persona.EstadoPersonaDto;
import pe.pucp.edu.squirlearn.business.persona.EstadoPersonaBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "EstadoPersona")
public class EstadoPersona {

    private EstadoPersonaBo estadoPersonaBo;
    
    public EstadoPersona(){
        this.estadoPersonaBo = new EstadoPersonaBo();
    }
    
    @WebMethod(operationName = "listarTodosEstadoPersona")
    public ArrayList<EstadoPersonaDto> listarTodosEstadoPersona() {
        return this.estadoPersonaBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorIdEstadoPersona")
    public EstadoPersonaDto obtenerPorIdEstadoPersona(@WebParam(name = "id") Integer id) {
        return this.estadoPersonaBo.obtenerPorId(id);
    }

}
