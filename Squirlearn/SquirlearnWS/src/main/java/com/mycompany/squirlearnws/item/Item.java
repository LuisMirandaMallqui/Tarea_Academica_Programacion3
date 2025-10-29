/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.item;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import pe.edu.pucp.squirlearn.model.item.ItemDto;
import pe.pucp.edu.squirlearn.business.item.ItemBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Item")
public class Item {

    private ItemBo itemBo;
    
    public Item(){
        this.itemBo = new ItemBo();
    }
    
    @WebMethod(operationName = "insertarItem")
    public Integer insertarItem(
            @WebParam(name = "precio") Double precio,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "esVenta") Boolean esVenta,
            @WebParam(name = "colorId") Integer colorId,
            @WebParam(name = "condicionId") Integer condicionId,
            @WebParam(name = "tamanoId") Integer tamanoId,
            @WebParam(name = "formatoId") Integer formatoId,
            @WebParam(name = "categoriaId") Integer categoriaId,
            @WebParam(name = "subcategoriaId") Integer subcategoriaId,
            @WebParam(name = "usuario") String usuario) {
            return this.itemBo.insertar(precio, nombre, descripcion, esVenta, colorId, 
                    condicionId, tamanoId, formatoId, categoriaId, subcategoriaId,usuario);

    }

    @WebMethod(operationName = "modificarItem")
    public Integer modificarItem(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "precio") Double precio,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "esVenta") Boolean esVenta,
            @WebParam(name = "colorId") Integer colorId,
            @WebParam(name = "estadoId") Integer estadoId,
            @WebParam(name = "condicionId") Integer condicionId,
            @WebParam(name = "tamanoId") Integer tamanoId,
            @WebParam(name = "formatoId") Integer formatoId,
            @WebParam(name = "categoriaId") Integer categoriaId,
            @WebParam(name = "subcategoriaId") Integer subcategoriaId,
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "usuarioCreacion") String usuarioCreacion) {
            return this.itemBo.modificar(id, precio, nombre, descripcion, esVenta, 
                    colorId, estadoId, condicionId, tamanoId, formatoId, categoriaId, 
                    subcategoriaId,usuario,usuarioCreacion);

        }

    @WebMethod(operationName = "obtenerPorIdItem")
    public ItemDto obtenerPorIdItem(@WebParam(name = "id") Integer id) {
        return this.itemBo.obtenerPorId(id);
    }

}
