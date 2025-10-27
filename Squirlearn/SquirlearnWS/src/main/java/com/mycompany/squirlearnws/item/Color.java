/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.item;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.item.ColorDto;
import pe.pucp.edu.squirlearn.business.item.ColorBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Color")
public class Color {

    private ColorBo colorBo;
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList<ColorDto> listarTodos() {
        return this.colorBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorId")
    public ColorDto obtenerPorId(@WebParam(name = "id") Integer id) {
        return this.colorBo.obtenerPorId(id);
    }

}
