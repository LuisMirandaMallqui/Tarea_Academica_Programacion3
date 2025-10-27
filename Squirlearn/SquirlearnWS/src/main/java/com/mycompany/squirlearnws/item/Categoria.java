/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.item;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.item.CategoriaDto;
import pe.pucp.edu.squirlearn.business.item.CategoriaBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Categoria")
public class Categoria {

    private CategoriaBo categoriaBo;
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList<CategoriaDto> listarTodos() {
        return this.categoriaBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorId")
    public CategoriaDto obtenerPorId(@WebParam(name = "id") Integer id) {
        return this.categoriaBo.obtenerPorId(id);
    }

}
