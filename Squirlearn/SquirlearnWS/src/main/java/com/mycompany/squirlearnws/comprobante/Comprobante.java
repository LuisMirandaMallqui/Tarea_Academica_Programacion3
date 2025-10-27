/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.comprobante;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteDto;
import pe.pucp.edu.squirlearn.business.comprobante.ComprobanteBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Comprobante")
public class Comprobante {

    private ComprobanteBo comprobanteBo;
    
    @WebMethod(operationName = "insertar")
    public Integer insertar(
            @WebParam(name = "monto") Double monto,
            @WebParam(name = "transaccionId") String transaccionId,
            @WebParam(name = "personaId") Integer personaId,
            @WebParam(name = "formaPagoId") Integer formaPagoId,
            @WebParam(name = "monedaId") Integer monedaId,
            @WebParam(name = "impuesto") Double impuesto) {
        return this.comprobanteBo.insertar(monto, transaccionId, personaId, formaPagoId, monedaId, impuesto);
    }

    @WebMethod(operationName = "listarPorDueno")
    public ArrayList listarPorDueno(
            @WebParam(name = "personaId") Integer personaId) {
        return this.comprobanteBo.listarPorDueno(personaId);
    }

    @WebMethod(operationName = "obtenerPorId")
    public ComprobanteDto obtenerPorId(
            @WebParam(name = "id") Integer id) {
        return this.comprobanteBo.obtenerPorId(id);
    }
}
