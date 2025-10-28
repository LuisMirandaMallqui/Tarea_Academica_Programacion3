/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.item;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.item.SubcategoriaDto;
import pe.pucp.edu.squirlearn.business.item.SubcategoriaBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Subcategoria")
public class Subcategoria {

    private SubcategoriaBo subcategoriaBo;
    
    public Subcategoria(){
        this.subcategoriaBo = new SubcategoriaBo();
    }
    
    @WebMethod(operationName = "listarPorCategoriaSubcategoria")
    public ArrayList<SubcategoriaDto> listarPorCategoriaSubcategoria(@WebParam(name = "categoriaId") Integer categoriaId) {
        return this.subcategoriaBo.listarPorCategoria(categoriaId);
    }

    @WebMethod(operationName = "listarTodosSubcategoria")
    public ArrayList<SubcategoriaDto> listarTodosSubcategoria() {
        return this.subcategoriaBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorIdSubcategoria")
    public SubcategoriaDto obtenerPorIdSubcategoria(@WebParam(name = "id") Integer id) {
        return this.subcategoriaBo.obtenerPorId(id);
    }

}
