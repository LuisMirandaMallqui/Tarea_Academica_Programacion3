/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.item;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.item.TamañoDto;
import pe.pucp.edu.squirlearn.business.item.TamanoBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Tamano")
public class Tamano {

    private TamanoBo tamanoBo;
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList<TamañoDto> listarTodos() {
        return this.tamanoBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorId")
    public TamañoDto obtenerPorId(@WebParam(name = "id") Integer id) {
        return this.tamanoBo.obtenerPorId(id);
    }

}
