/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.edu.squirlearn.business.chat;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.squirlearn.dao.chat.PersonaChatDao;
import pe.edu.pucp.squirlearn.daoImpl.chat.PersonaChatDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.ChatDto;
import pe.edu.pucp.squirlearn.model.chat.PersonaChatDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

/**
 *
 * @author gabri
 */
public class PersonaChatBo {
    
    private PersonaChatDao personaChatDao; 
    
    public PersonaChatBo(){
        this.personaChatDao = new PersonaChatDaoImpl();
    }
    
    public Integer insertar(Integer personaId, Integer chatId, Date ultimaVez){
        PersonaChatDto personaChatDto = new PersonaChatDto();
        
        ChatDto chat = new ChatDto();
        chat.setChatId(chatId);
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(personaId);
        
        personaChatDto.setChat(chat);
        personaChatDto.setPersona(persona);
        personaChatDto.setUltimaActividad(ultimaVez);
        
        return this.personaChatDao.insertar(personaChatDto);
    }
    
    public Integer modificar(Integer id, Date ultimaVez){
        PersonaChatDto personaChatDto = new PersonaChatDto();
        personaChatDto.setId(id);
        personaChatDto.setUltimaActividad(ultimaVez);
        return this.personaChatDao.modificar(personaChatDto);
    }
    
    public ArrayList<PersonaChatDto> listarPorPersona(Integer personaId){
        PersonaChatDto personaChatDto = new PersonaChatDto();
        
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(personaId);
        
        personaChatDto.setPersona(persona);
        
        return this.personaChatDao.listarPorPersona(personaId);//falta implementación
    }
    
}
