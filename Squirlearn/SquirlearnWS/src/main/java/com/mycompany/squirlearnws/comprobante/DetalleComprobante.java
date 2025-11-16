package com.mycompany.squirlearnws.comprobante;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.comprobante.DetalleComprobanteDto;
import pe.pucp.edu.squirlearn.business.comprobante.DetalleComprobanteBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "DetalleComprobante")
public class DetalleComprobante {

    private DetalleComprobanteBo detalleComprobanteBo;
    
    public DetalleComprobante(){
        this.detalleComprobanteBo = new DetalleComprobanteBo();
    }
    
    @WebMethod(operationName = "insertarDetalleComprobante")
    public Integer insertarDetalleComprobante(
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "precio") Double precio,
            @WebParam(name = "itemId") Integer itemId,
            @WebParam(name = "alquilerId") Integer alquilerId,
            @WebParam(name = "comprobanteId") Integer comprobanteId,
            @WebParam(name = "usuario") String usuario) {
        return this.detalleComprobanteBo.insertar(descripcion, precio, itemId, alquilerId, comprobanteId,usuario);
    }

    @WebMethod(operationName = "listarPorComprobanteDetalleComprobante")
    public ArrayList listarPorComprobanteDetalleComprobante(
            @WebParam(name = "comprobanteId") Integer comprobanteId) {
        return this.detalleComprobanteBo.listarPorComprobante(comprobanteId);
    }

    @WebMethod(operationName = "obtenerPorIdDetalleComprobante")
    public DetalleComprobanteDto obtenerPorIdDetalleComprobante(
            @WebParam(name = "id") Integer id) {
        return this.detalleComprobanteBo.obtenerPorId(id);
    }
}
