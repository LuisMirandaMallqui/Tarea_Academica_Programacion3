/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.inciNoti;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.sql.Date;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.inciNoti.IncidenciaDto;
import pe.pucp.edu.squirlearn.business.inciNoti.IncidenciaBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Incidencia")
public class Incidencia {

    private IncidenciaBo incidenciaBo; 
    
    @WebMethod(operationName = "insertar")
    public Integer insertar(
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "notificacionId") Integer notificacionId,
            @WebParam(name = "personaId") Integer personaId,
            @WebParam(name = "motivoId") Integer motivoId,
            @WebParam(name = "creadorId") Integer creadorId) {
        return this.incidenciaBo.insertar(descripcion, notificacionId, personaId, motivoId, creadorId);
    }

    @WebMethod(operationName = "modificar")
    public Integer modificar(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "fechaCreacion") Date fechaCreacion,
            @WebParam(name = "fechaSolucion") Date fechaSolucion,
            @WebParam(name = "notificacionId") Integer notificacionId,
            @WebParam(name = "personaId") Integer personaId,
            @WebParam(name = "motivoId") Integer motivoId,
            @WebParam(name = "resuelto") Integer resuelto,
            @WebParam(name = "creadorId") Integer creadorId,
            @WebParam(name = "solucionadorId") Integer solucionadorId,
            @WebParam(name = "modificadorId") Integer modificadorId) {
        return this.incidenciaBo.modificar(id, descripcion, fechaCreacion, fechaSolucion, notificacionId,
                personaId, motivoId, resuelto, creadorId, solucionadorId, modificadorId);
    }

    @WebMethod(operationName = "listarPorResolucion")
    public ArrayList<IncidenciaDto> listarPorResolucion(
            @WebParam(name = "resuelto") Boolean resuelto) {
        return this.incidenciaBo.listarPorResolucion(resuelto);
    }

    @WebMethod(operationName = "obtenerPorId")
    public IncidenciaDto obtenerPorId(
            @WebParam(name = "id") Integer id) {
        return this.incidenciaBo.obtenerPorId(id);
    }

}
