/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
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
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList<RolPersonaDto> listarTodos() {
        return this.rolPersonaBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorId")
    public RolPersonaDto obtenerPorId(@WebParam(name = "id") Integer id) {
        return this.rolPersonaBo.obtenerPorId(id);
    }

}
