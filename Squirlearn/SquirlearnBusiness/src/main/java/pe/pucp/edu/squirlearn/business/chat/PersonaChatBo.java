package pe.pucp.edu.squirlearn.business.chat;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.chat.PersonaChatDao;
import pe.edu.pucp.squirlearn.daoImpl.chat.PersonaChatDaoImpl;
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
     //Este insertar está implementado dentro del BO de insertar Chat 
//    public Integer insertar(Integer personaId, Integer chatId){
//        PersonaChatDto personaChatDto = new PersonaChatDto();
//        
//        ChatDto chat = new ChatDto();
//        chat.setChatId(chatId);
//        PersonaDto persona = new PersonaDto();
//        persona.setPersonaId(personaId);
//        
//        personaChatDto.setChat(chat);
//        personaChatDto.setPersona(persona);
//        
//        return this.personaChatDao.insertar(personaChatDto);
//    }
    
    public ArrayList<PersonaChatDto> listarPorPersona(Integer personaId){
        PersonaChatDto personaChatDto = new PersonaChatDto();
        
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(personaId);
        
        personaChatDto.setPersona(persona);
        
        return this.personaChatDao.listarPorPersona(personaId);//falta implementación
    }
    
}
