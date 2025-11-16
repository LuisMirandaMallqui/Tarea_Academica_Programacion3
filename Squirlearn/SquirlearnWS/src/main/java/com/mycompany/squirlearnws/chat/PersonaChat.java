package com.mycompany.squirlearnws.chat;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.pucp.edu.squirlearn.business.chat.PersonaChatBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "PersonaChat")
public class PersonaChat {

    private PersonaChatBo personaChatBo;
    
    public PersonaChat(){
        this.personaChatBo = new PersonaChatBo();
    }

    @WebMethod(operationName = "listarPorPersona")
    public ArrayList listarPorPersona(
            @WebParam(name = "personaId") Integer personaId) {
        return this.personaChatBo.listarPorPersona(personaId);
    }
}
