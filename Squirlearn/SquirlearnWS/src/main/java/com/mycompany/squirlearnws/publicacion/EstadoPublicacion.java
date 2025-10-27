/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
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
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList<EstadoPublicacionDto> listarTodos() {
        return this.estadoPublicacionBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorId")
    public EstadoPublicacionDto obtenerPorId(@WebParam(name = "id") Integer id) {
        return this.estadoPublicacionBo.obtenerPorId(id);
    }

}
