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
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "imagen") byte[] imagen) {
            return this.itemBo.insertar(precio, nombre, descripcion, esVenta, colorId, 
                    condicionId, tamanoId, formatoId, categoriaId, subcategoriaId,usuario,imagen);

    }

    @WebMethod(operationName = "modificarItem")
    public Integer modificarItem(
            @WebParam(name = "id") Integer id,
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
            return this.itemBo.modificar(id, precio, nombre, descripcion, esVenta, 
                    colorId, condicionId, tamanoId, formatoId, categoriaId, 
                    subcategoriaId,usuario);
        }

    @WebMethod(operationName = "obtenerPorIdItem")
    public ItemDto obtenerPorIdItem(@WebParam(name = "id") Integer id) {
        return this.itemBo.obtenerPorId(id);
    }
    
    @WebMethod(operationName = "cambiarEstadoItem")
    public Integer cambiarEstadoItem(
            @WebParam(name = "itemId") Integer itemId,
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "estado") String estado) {
        return this.itemBo.cambiarEstadoItem(itemId, usuario, estado);
    }

}
