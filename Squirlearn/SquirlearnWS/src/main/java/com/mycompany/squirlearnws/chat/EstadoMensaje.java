/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.chat;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.chat.EstadoMensajeDto;
import pe.pucp.edu.squirlearn.business.chat.EstadoMensajeBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "EstadoMensaje")
public class EstadoMensaje {
    
    private EstadoMensajeBo estadoMensajeBo;
    
    public EstadoMensaje(){
        this.estadoMensajeBo = new EstadoMensajeBo();
    }

    @WebMethod(operationName = "listarTodosEstadoMensaje")
    public ArrayList listarTodosEstadoMensaje() {
        return this.estadoMensajeBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorIdEstadoMensaje")
    public EstadoMensajeDto obtenerPorIdEstadoMensaje(@WebParam(name = "id") Integer id) {
        return this.estadoMensajeBo.obtenerPorId(id);
    }
}
