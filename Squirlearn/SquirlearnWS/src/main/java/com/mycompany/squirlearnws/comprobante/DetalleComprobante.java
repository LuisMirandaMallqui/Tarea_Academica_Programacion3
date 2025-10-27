/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
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
    
    @WebMethod(operationName = "insertar")
    public Integer insertar(
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "precio") Double precio,
            @WebParam(name = "itemId") Integer itemId,
            @WebParam(name = "alquilerId") Integer alquilerId,
            @WebParam(name = "comprobanteId") Integer comprobanteId) {
        return this.detalleComprobanteBo.insertar(descripcion, precio, itemId, alquilerId, comprobanteId);
    }

    @WebMethod(operationName = "listarPorComprobante")
    public ArrayList listarPorComprobante(
            @WebParam(name = "comprobanteId") Integer comprobanteId) {
        return this.detalleComprobanteBo.listarPorComprobante(comprobanteId);
    }

    @WebMethod(operationName = "obtenerPorId")
    public DetalleComprobanteDto obtenerPorId(
            @WebParam(name = "id") Integer id) {
        return this.detalleComprobanteBo.obtenerPorId(id);
    }
}
