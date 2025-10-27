/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.chat;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.chat.EstadoChatDto;
import pe.pucp.edu.squirlearn.business.chat.EstadoChatBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "EstadoChat")
public class EstadoChat {

    private EstadoChatBo estadoChatBo;
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList listarTodos() {
        return this.estadoChatBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorId")
    public EstadoChatDto obtenerPorId(@WebParam(name = "id") Integer id) {
        return this.estadoChatBo.obtenerPorId(id);
    }
}
