
package pe.pucp.edu.squirlearn.business.chat;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.squirlearn.dao.chat.ChatDao;
import pe.edu.pucp.squirlearn.daoImpl.chat.ChatDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.ChatDto;
import pe.edu.pucp.squirlearn.model.chat.EstadoChatDto;


public class ChatBo {
    
    private ChatDao chatDao;
    
    public ChatBo(){
        this.chatDao = new ChatDaoImpl();
    }
    
    public Integer insertar(Integer creadorId){
        ChatDto chatDto = new ChatDto();
        
        EstadoChatDto estadoChat = new EstadoChatDto();
        estadoChat.setEstadoChatId(1);
        
        chatDto.setEstadoChat(estadoChat);
        chatDto.setUsuarioCreacion(creadorId);
        
        return this.chatDao.insertar(chatDto);
    }
    
    public Integer modificar(Integer chatId, Integer estadoId, Date creacion,
            Integer creador, Integer modificadorId){
        ChatDto chatDto = new ChatDto();
        
        EstadoChatDto estadoChat = new EstadoChatDto();
        estadoChat.setEstadoChatId(estadoId);
        
        chatDto.setChatId(chatId);
        chatDto.setUsuarioCreacion(creador);
        chatDto.setFechaCreacion((java.sql.Date) creacion);
        chatDto.setEstadoChat(estadoChat);
        chatDto.setUsuarioModificacion(modificadorId);
        
        return this.chatDao.modificar(chatDto);
    }
    
    public ArrayList<ChatDto> listarTodos(){
        return this.chatDao.listarTodos();
    }
    
    public ChatDto obtenerPorId(Integer id){
        return this.chatDao.obtenerPorId(id);
    }
    
}
