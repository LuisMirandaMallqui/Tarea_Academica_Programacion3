package com.mycompany.squirlearnws.chat;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.sql.Date;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.chat.ChatDto;
import pe.pucp.edu.squirlearn.business.chat.ChatBo;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "Chat")
public class Chat {

    private ChatBo chatBo;
    
    public Chat(){
        this.chatBo = new ChatBo();
    }
    
    @WebMethod(operationName = "insertarChat")
    public Integer insertarChat(
            @WebParam(name = "creadorId") Integer creadorId,
            @WebParam(name = "usuario") String usuario) {
        return this.chatBo.insertar(creadorId,usuario);
    }

    @WebMethod(operationName = "modificarChat")
    public Integer modificarChat(
            @WebParam(name = "chatId") Integer chatId,
            @WebParam(name = "estadoId") Integer estadoId,
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "usuarioCreacion") String usuarioCreacion,
            @WebParam(name = "usuarioModificacion") String usuarioModificacion) {
        return this.chatBo.modificar(chatId, estadoId, usuario,usuarioCreacion,usuarioModificacion);
    }

    @WebMethod(operationName = "listarTodosChat")
    public ArrayList listarTodosChat() {
        return this.chatBo.listarTodos();
    }

    @WebMethod(operationName = "obtenerPorIdChat")
    public ChatDto obtenerPorIdChat(@WebParam(name = "id") Integer id) {
        return this.chatBo.obtenerPorId(id);
    }
}
