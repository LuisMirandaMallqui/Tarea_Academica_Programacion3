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
    
    public Mensaje(){
        this.mensajeBo = new MensajeBo();
    }
    
    @WebMethod(operationName = "insertarMensaje")
    public Integer insertarMensaje(
            @WebParam(name = "chatId") Integer chatId,
            @WebParam(name = "mensaje") String mensaje,
            @WebParam(name = "personaId") Integer personaId,
            @WebParam(name = "usuario") String usuario) {
        return this.mensajeBo.insertar(chatId, mensaje, personaId,usuario);
    }

    @WebMethod(operationName = "modificarMensaje")
    public Integer modificarMensaje(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "chatId") Integer chatId,
            @WebParam(name = "mensaje") String mensaje,
            @WebParam(name = "estadoId") Integer estadoId,
            @WebParam(name = "personaId") Integer personaId,
            @WebParam(name = "fechaEnvio") Date fechaEnvio,
            @WebParam(name = "fechaLeido") Date fechaLeido,
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "usuarioCreacion") String usuarioCreacion) {
        return this.mensajeBo.modificar(id, chatId, mensaje, estadoId, personaId, fechaEnvio,
                fechaLeido, usuario, usuarioCreacion);
    }

    @WebMethod(operationName = "listarTodosMensaje")
    public ArrayList listarTodosMensaje() {
        return this.mensajeBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorIdMensaje")
    public MensajeDto obtenerPorIdMensaje(@WebParam(name = "id") Integer id) {
        return this.mensajeBo.obtenerPorId(id);
    }
}
