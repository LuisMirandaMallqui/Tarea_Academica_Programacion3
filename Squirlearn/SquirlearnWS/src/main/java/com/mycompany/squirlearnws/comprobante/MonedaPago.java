/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.comprobante;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.comprobante.MonedaPagoDto;
import pe.pucp.edu.squirlearn.business.comprobante.MonedaPagoBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "MonedaPago")
public class MonedaPago {

    private MonedaPagoBo monedaPagoBo;
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList listarTodos() {
        return this.monedaPagoBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorId")
    public MonedaPagoDto obtenerPorId(@WebParam(name = "id") Integer id) {
        return this.monedaPagoBo.obtenerPorId(id);
    }
}
