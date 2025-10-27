/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.publicacion;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.sql.Date;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionDto;
import pe.pucp.edu.squirlearn.business.publicacion.PublicacionBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Publicacion")
public class Publicacion {

    private PublicacionBo publicacionBo;
    
    public Publicacion(){
        this.publicacionBo = new PublicacionBo();
    }
    
    @WebMethod(operationName = "insertarPublicacion")
    public Integer insertar(
            @WebParam(name = "itemId") Integer itemId,
            @WebParam(name = "personaId") Integer personaId
    ) {
        return this.publicacionBo.insertar(itemId, personaId);
    }

    @WebMethod(operationName = "modificarPublicacion")
    public Integer modificarPublicacion(
            @WebParam(name = "publicacionId") Integer publicacionId,
            @WebParam(name = "fechaAlta") Date fechaAlta,
            @WebParam(name = "estadoId") Integer estadoId,
            @WebParam(name = "itemId") Integer itemId,
            @WebParam(name = "personaId") Integer personaId,
            @WebParam(name = "calificacion") Integer calificacion
    ) {
        return this.publicacionBo.modificar(publicacionId, fechaAlta, estadoId, itemId, personaId, calificacion);
    }

    @WebMethod(operationName = "listarPorEstadoPublicacion")
    public ArrayList<PublicacionDto> listarPorEstadoPublicacion(@WebParam(name = "estadoId") Integer estadoId) {
        return this.publicacionBo.listarPorEstado(estadoId);
    }

    @WebMethod(operationName = "listarPorDuenoPublicacion")
    public ArrayList<PublicacionDto> listarPorDuenoPublicacion(@WebParam(name = "personaId") Integer personaId) {
        return this.publicacionBo.listarPorDueno(personaId);
    }

    @WebMethod(operationName = "obtenerPorIdPublicacion")
    public PublicacionDto obtenerPorIdPublicacion(@WebParam(name = "id") Integer id) {
        return this.publicacionBo.obtenerPorId(id);
    }

}
