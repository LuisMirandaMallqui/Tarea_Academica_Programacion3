package pe.edu.pucp.squirlearn.dao.chat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.chat.ChatDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.ChatDto;
import pe.edu.pucp.squirlearn.model.chat.EstadoChatDto;

public class ChatDaoTest {

    private ChatDao chatDAO;

    public ChatDaoTest() {
        this.chatDAO = new ChatDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        EstadoChatDto estado = new EstadoChatDto();
//        estado.setEstadoChatId(1);
//        ChatDto chat = new ChatDto();
//        chat.setEstadoChat(estado);
//        chat.setUsuarioCreacion("usuarioTest");
//        Integer resultado = this.chatDAO.insertar(chat);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ChatDto chat = this.chatDAO.obtenerPorId(1);
//        if (chat != null) {
//            System.out.println(chat.getChatId());
//            System.out.println(chat.getEstadoChat().getEstadoChatId());
//            System.out.println(chat.getUsuarioCreacion());
//            System.out.println(chat.getUsuarioModificacion());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<ChatDto> lista = this.chatDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            ChatDto chat = lista.get(i);
//            System.out.println("Dato:");
//            System.out.println(chat.getChatId());
//            if (chat.getEstadoChat() != null) {
//                System.out.println(chat.getEstadoChat().getEstadoChatId());
//            }
//            System.out.println(chat.getUsuarioCreacion());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        EstadoChatDto estado = new EstadoChatDto();
//        estado.setEstadoChatId(1);
//        ChatDto chat = new ChatDto();
//        chat.setChatId(1);
//        chat.setEstadoChat(estado);
//        chat.setUsuarioCreacion(null);
//        chat.setUsuarioModificacion("modificadoTest");
//        Integer resultado = this.chatDAO.modificar(chat);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ChatDto chat = new ChatDto();
//        chat.setChatId(5);
//        this.chatDAO.eliminar(chat);
//    }
}
