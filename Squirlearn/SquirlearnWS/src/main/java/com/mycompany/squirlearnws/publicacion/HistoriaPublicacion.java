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
    
    public HistoriaPublicacion(){
        this.historiaPublicacionBo = new HistoriaPublicacionBo();
    }
    
    @WebMethod(operationName = "insertarHistoriaPublicacion")
    public Integer insertarHistoriaPublicacion(
            @WebParam(name = "publicacionId") Integer publicacionId,
            @WebParam(name = "modificadorId") Integer modificadorId
    ) {
        return this.historiaPublicacionBo.insertar(publicacionId, modificadorId);
    }

    @WebMethod(operationName = "listarTodosHistoriaPublicacion")
    public ArrayList<HistoriaPublicacionDto> listarTodosHistoriaPublicacion() {
        return this.historiaPublicacionBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorIdHistoriaPublicacion")
    public HistoriaPublicacionDto obtenerPorIdHistoriaPublicacion(@WebParam(name = "id") Integer id) {
        return this.historiaPublicacionBo.obtenerPorId(id);
    }

}
