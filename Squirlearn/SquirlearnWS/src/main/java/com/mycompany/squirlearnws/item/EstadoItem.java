/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.item;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.item.EstadoItemDto;
import pe.pucp.edu.squirlearn.business.item.EstadoItemBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "EstadoItem")
public class EstadoItem {

    private EstadoItemBo estadoItemBo;
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList<EstadoItemDto> listarTodos() {
        return this.estadoItemBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorId")
    public EstadoItemDto obtenerPorId(@WebParam(name = "id") Integer id) {
        return this.estadoItemBo.obtenerPorId(id);
    }

}
