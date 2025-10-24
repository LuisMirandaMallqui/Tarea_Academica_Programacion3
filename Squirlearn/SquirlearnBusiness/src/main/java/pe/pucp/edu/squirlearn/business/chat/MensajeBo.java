
package pe.pucp.edu.squirlearn.business.chat;

import java.util.ArrayList;
import java.sql.Date;
import pe.edu.pucp.squirlearn.dao.chat.MensajeDao;
import pe.edu.pucp.squirlearn.daoImpl.chat.MensajeDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.ChatDto;
import pe.edu.pucp.squirlearn.model.chat.EstadoMensajeDto;
import pe.edu.pucp.squirlearn.model.chat.MensajeDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class MensajeBo {
    
    private MensajeDao mensajeDao;
    
    public MensajeBo(){
        this.mensajeDao = new MensajeDaoImpl();
    }
    
    public Integer insertar(Integer chatId, String mensaje, Integer personaId){
        MensajeDto mensajeDto = new MensajeDto();
        
        ChatDto chat = new ChatDto();
        chat.setChatId(chatId);
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(personaId);
        EstadoMensajeDto estado = new EstadoMensajeDto();
        estado.setEstadoMsjId(1);
        
        mensajeDto.setChat(chat);
        mensajeDto.setMensaje(mensaje);
        mensajeDto.setPersona(persona);
        mensajeDto.setEstadoMensaje(estado);
        
        return this.mensajeDao.insertar(mensajeDto);
    }
    
    public Integer modificar(Integer id, Integer chatId, String mensaje,Integer estadoId,
            Integer personaId, Date fechaEnvio){
        MensajeDto mensajeDto = new MensajeDto(); 
        
        EstadoMensajeDto estado = new EstadoMensajeDto();
        estado.setEstadoMsjId(estadoId);
        ChatDto chat = new ChatDto();
        chat.setChatId(chatId);
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(personaId);
        
        mensajeDto.setChat(chat);
        mensajeDto.setMensajeId(id);
        mensajeDto.setPersona(persona);
        mensajeDto.setMensaje(mensaje);
        mensajeDto.setFechaEnvio((java.sql.Date) fechaEnvio);
        mensajeDto.setEstadoMensaje(estado);
        
        return this.mensajeDao.modificar(mensajeDto);
    }
    
    public ArrayList<MensajeDto> listarTodos(){
        return this.mensajeDao.listarTodos();
    }
    
    public MensajeDto obtenerPorId(Integer id){
        return this.mensajeDao.obtenerPorId(id);
    }
}
