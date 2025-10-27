/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.squirlearnws.chat;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.sql.Date;
import java.util.ArrayList;
import pe.pucp.edu.squirlearn.business.chat.PersonaChatBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "PersonaChat")
public class PersonaChat {

    private PersonaChatBo personaChatBo;
    
    @WebMethod(operationName = "insertar")
    public Integer insertar(
            @WebParam(name = "personaId") Integer personaId,
            @WebParam(name = "chatId") Integer chatId,
            @WebParam(name = "ultimaVez") Date ultimaVez) {
        return this.personaChatBo.insertar(personaId, chatId, ultimaVez);
    }

    @WebMethod(operationName = "modificar")
    public Integer modificar(
            @WebParam(name = "id") Integer id,
            @WebParam(name = "ultimaVez") Date ultimaVez) {
        return this.personaChatBo.modificar(id, ultimaVez);
    }

    @WebMethod(operationName = "listarPorPersona")
    public ArrayList listarPorPersona(
            @WebParam(name = "personaId") Integer personaId) {
        return this.personaChatBo.listarPorPersona(personaId);
    }
}
