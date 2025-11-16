
package pe.pucp.edu.squirlearn.business.chat;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.squirlearn.dao.chat.ChatDao;
import pe.edu.pucp.squirlearn.dao.chat.PersonaChatDao;
import pe.edu.pucp.squirlearn.daoImpl.chat.ChatDaoImpl;
import pe.edu.pucp.squirlearn.daoImpl.chat.PersonaChatDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.ChatDto;
import pe.edu.pucp.squirlearn.model.chat.EstadoChatDto;
import pe.edu.pucp.squirlearn.model.chat.PersonaChatDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;


public class ChatBo {
    
    private ChatDao chatDao;
    private PersonaChatDao personaChatDao;
    
    public ChatBo(){
        this.chatDao = new ChatDaoImpl();
    }
    
    public Integer insertar(Integer creadorId,String usuarioCreacion){
        ChatDto chatDto = new ChatDto();
        
        EstadoChatDto estadoChat = new EstadoChatDto();
        estadoChat.setEstadoChatId(1);
        
        chatDto.setEstadoChat(estadoChat);
        chatDto.setUsuarioCreacion(usuarioCreacion);
        
        int resultado =  this.chatDao.insertar(chatDto);
        
        PersonaChatDto personaChatDto = new PersonaChatDto();
        
        ChatDto chat = new ChatDto();
        chat.setChatId(resultado);
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(creadorId);
        
        personaChatDto.setChat(chat);
        personaChatDto.setPersona(persona);
        this.personaChatDao = new PersonaChatDaoImpl();
        this.personaChatDao.insertar(personaChatDto);
        
        return resultado;
        
    }
    
    public Integer modificar(Integer chatId, Integer estadoId,
            String usuario,String usuarioCreacion,String usuarioModificacion){
        ChatDto chatDto = new ChatDto();
        
        EstadoChatDto estadoChat = new EstadoChatDto();
        estadoChat.setEstadoChatId(estadoId);
        
        chatDto.setChatId(chatId);
        chatDto.setUsuarioCreacion(usuarioCreacion);
        chatDto.setEstadoChat(estadoChat);
        chatDto.setUsuarioCreacion(usuarioCreacion);
        chatDto.setUsuarioModificacion(usuarioModificacion);
        
        return this.chatDao.modificar(chatDto);
    }
    
    public ArrayList<ChatDto> listarTodos(){
        return this.chatDao.listarTodos();
    }
    
    public ChatDto obtenerPorId(Integer id){
        return this.chatDao.obtenerPorId(id);
    }
    
}
