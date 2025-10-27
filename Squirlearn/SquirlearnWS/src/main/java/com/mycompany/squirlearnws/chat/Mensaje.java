/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.chat;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.sql.Date;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.chat.MensajeDto;
import pe.pucp.edu.squirlearn.business.chat.MensajeBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Mensaje")
public class Mensaje {

    private MensajeBo mensajeBo;
    
    @WebMethod(operationName = "insertar")
    public Integer insertar(
            @WebParam(name = "chatId") Integer chatId,
            @WebParam(name = "mensaje") String mensaje,
            @WebParam(name = "personaId") Integer personaId) {
        return this.mensajeBo.insertar(chatId, mensaje, personaId);
    }

    @WebMethod(operationName = "modificar")
    public Integer modificar(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "chatId") Integer chatId,
            @WebParam(name = "mensaje") String mensaje,
            @WebParam(name = "estadoId") Integer estadoId,
            @WebParam(name = "personaId") Integer personaId,
            @WebParam(name = "fechaEnvio") Date fechaEnvio) {
        return this.mensajeBo.modificar(id, chatId, mensaje, estadoId, personaId, fechaEnvio);
    }

    @WebMethod(operationName = "listarTodos")
    public ArrayList listarTodos() {
        return this.mensajeBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorId")
    public MensajeDto obtenerPorId(@WebParam(name = "id") Integer id) {
        return this.mensajeBo.obtenerPorId(id);
    }
}
