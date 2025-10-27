/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.publicacion;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.publicacion.HistoriaPublicacionDto;
import pe.pucp.edu.squirlearn.business.publicacion.HistoriaPublicacionBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "HistoriaPublicacion")
public class HistoriaPublicacion {

    private HistoriaPublicacionBo historiaPublicacionBo;
    
    @WebMethod(operationName = "insertar")
    public Integer insertar(
            @WebParam(name = "publicacionId") Integer publicacionId,
            @WebParam(name = "modificadorId") Integer modificadorId
    ) {
        return this.historiaPublicacionBo.insertar(publicacionId, modificadorId);
    }

    @WebMethod(operationName = "listarTodos")
    public ArrayList<HistoriaPublicacionDto> listarTodos() {
        return this.historiaPublicacionBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorId")
    public HistoriaPublicacionDto obtenerPorId(@WebParam(name = "id") Integer id) {
        return this.historiaPublicacionBo.obtenerPorId(id);
    }

}
