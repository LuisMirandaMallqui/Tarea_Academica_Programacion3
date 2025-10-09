/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.edu.squirlearn.business.chat;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.chat.MensajeDao;
import pe.edu.pucp.squirlearn.daoImpl.chat.MensajeDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.ChatDto;
import pe.edu.pucp.squirlearn.model.chat.EstadoMensajeDto;
import pe.edu.pucp.squirlearn.model.chat.MensajeDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

/**
 *
 * @author gabri
 */
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
    
    public Integer modificar(Integer id, Integer estadoId){
        MensajeDto mensajeDto = new MensajeDto(); // modifica solo el estado
        
        EstadoMensajeDto estado = new EstadoMensajeDto();
        estado.setEstadoMsjId(estadoId);
        
        mensajeDto.setMensajeId(id);
        mensajeDto.setEstadoMensaje(estado);
        
        return this.mensajeDao.insertar(mensajeDto);
    }
    
    public ArrayList<MensajeDto> listarTodos(){
        return this.mensajeDao.listarTodos();
    }
    
    public MensajeDto obtenerPorId(Integer id){
        return this.mensajeDao.obtenerPorId(id);
    }
}
