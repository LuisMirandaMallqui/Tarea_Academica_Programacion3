package pe.pucp.edu.squirlearn.business.chat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.chat.PersonaChatDto;

public class PersonaChatBoTest {

    private PersonaChatBo personaChatBO;

    public PersonaChatBoTest() {
        this.personaChatBO = new PersonaChatBo();
    }

//    @Test
//    public void testListarPorPersona() {
//        System.out.println("listarPorPersona");
//        // AJUSTA el ID de persona según tu BD
//        ArrayList<PersonaChatDto> lista = this.personaChatBO.listarPorPersona(1);
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getChat().getChatId());
//        }
//    }
}
