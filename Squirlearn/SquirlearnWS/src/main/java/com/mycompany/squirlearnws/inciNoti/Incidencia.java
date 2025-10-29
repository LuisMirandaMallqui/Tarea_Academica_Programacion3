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
    
    public Incidencia(){
        this.incidenciaBo = new IncidenciaBo();
    }
    
    @WebMethod(operationName = "insertarIncidencia")
    public Integer insertarIncidencia(
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "notificacionId") Integer notificacionId,
            @WebParam(name = "personaId") Integer personaId,
            @WebParam(name = "motivoId") Integer motivoId,
            @WebParam(name = "usuario") String usuario) {
        return this.incidenciaBo.insertar(descripcion, notificacionId, personaId, motivoId, usuario);
    }

    @WebMethod(operationName = "modificarIncidencia")
    public Integer modificarIncidencia(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "fechaSolucion") Date fechaSolucion,
            @WebParam(name = "notificacionId") Integer notificacionId,
            @WebParam(name = "personaId") Integer personaId,
            @WebParam(name = "motivoId") Integer motivoId,
            @WebParam(name = "resuelto") Integer resuelto,
            @WebParam(name = "solucionadorId") Integer solucionadorId,
            @WebParam(name = "usuarioCreacion") String usuarioCreacion) {
        return this.incidenciaBo.modificar(id, descripcion, fechaSolucion, notificacionId,
                personaId, motivoId, resuelto, solucionadorId, usuarioCreacion);
    }

    @WebMethod(operationName = "listarPorResolucionIncidencia")
    public ArrayList<IncidenciaDto> listarPorResolucionIncidencia(
            @WebParam(name = "resuelto") Boolean resuelto) {
        return this.incidenciaBo.listarPorResolucion(resuelto);
    }

    @WebMethod(operationName = "obtenerPorIdIncidencia")
    public IncidenciaDto obtenerPorIdIncidencia(
            @WebParam(name = "id") Integer id) {
        return this.incidenciaBo.obtenerPorId(id);
    }

}
