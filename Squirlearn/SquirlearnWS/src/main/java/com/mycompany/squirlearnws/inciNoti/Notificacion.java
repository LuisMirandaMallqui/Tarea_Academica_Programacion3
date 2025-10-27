/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.inciNoti;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.inciNoti.NotificacionDto;
import pe.pucp.edu.squirlearn.business.inciNoti.NotificacionBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Notificacion")
public class Notificacion {

    private NotificacionBo notificacionBo;
    
    @WebMethod(operationName = "insertar")
    public Integer insertar(
            @WebParam(name = "mensaje") String mensaje,
            @WebParam(name = "personaId") Integer personaId,
            @WebParam(name = "motivoId") Integer motivoId) {
        return this.notificacionBo.insertar(mensaje, personaId, motivoId);
    }

    @WebMethod(operationName = "listarPorPersona")
    public ArrayList<NotificacionDto> listarPorPersona(
            @WebParam(name = "personaId") Integer personaId) {
        return this.notificacionBo.listarPorPersona(personaId);
    }

    @WebMethod(operationName = "obtenerPorId")
    public NotificacionDto obtenerPorId(
            @WebParam(name = "id") Integer id) {
        return this.notificacionBo.obtenerPorId(id);
    }

}
