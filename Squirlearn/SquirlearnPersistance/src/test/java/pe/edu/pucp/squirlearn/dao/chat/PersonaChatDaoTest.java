package pe.edu.pucp.squirlearn.dao.chat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.chat.PersonaChatDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.ChatDto;
import pe.edu.pucp.squirlearn.model.chat.PersonaChatDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class PersonaChatDaoTest {

    private PersonaChatDao personaChatDAO;

    public PersonaChatDaoTest() {
        this.personaChatDAO = new PersonaChatDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ChatDto chat = new ChatDto();
//        chat.setChatId(1);
//        PersonaDto persona = new PersonaDto();
//        persona.setPersonaId(2);
//
//        PersonaChatDto pc = new PersonaChatDto();
//        pc.setChat(chat);
//        pc.setPersona(persona);
//
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<PersonaChatDto> lista = this.personaChatDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            PersonaChatDto pc = lista.get(i);
//            System.out.println("Dato:");
//            System.out.println(pc.getChat().getChatId());
//            System.out.println(pc.getPersona().getPersonaId());
//        }
//    }


}
