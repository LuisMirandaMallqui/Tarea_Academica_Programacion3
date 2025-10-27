/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.inciNoti;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.inciNoti.MotivoDto;
import pe.pucp.edu.squirlearn.business.inciNoti.MotivoBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Motivo")
public class Motivo {

    private MotivoBo motivoBo;
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList listarTodos() {
        return this.motivoBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorId")
    public MotivoDto obtenerPorId(@WebParam(name = "id") Integer id) {
        return this.motivoBo.obtenerPorId(id);
    }
}
