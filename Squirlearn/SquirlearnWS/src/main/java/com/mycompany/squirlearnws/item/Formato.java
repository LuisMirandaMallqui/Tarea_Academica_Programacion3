/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.item;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.item.FormatoDto;
import pe.pucp.edu.squirlearn.business.item.FormatoBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Formato")
public class Formato {

    private FormatoBo formatoBo;
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList<FormatoDto> listarTodos() {
        return this.formatoBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorId")
    public FormatoDto obtenerPorId(@WebParam(name = "id") Integer id) {
        return this.formatoBo.obtenerPorId(id);
    }

}
