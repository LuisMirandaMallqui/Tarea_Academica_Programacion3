package pe.pucp.edu.squirlearn.business.chat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.chat.ChatDto;

public class ChatBoTest {

    private ChatBo chatBO;

    public ChatBoTest() {
        this.chatBO = new ChatBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<ChatDto> lista = this.chatBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getChatId());
//            System.out.println(lista.get(i).getEstadoChat().getEstadoChatId());
//            System.out.println(lista.get(i).getUsuarioCreacion());
//            System.out.println(lista.get(i).getUsuarioModificacion());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        ChatDto entidad = this.chatBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getChatId());
//            System.out.println(entidad.getEstadoChat().getEstadoChatId());
//            System.out.println(entidad.getUsuarioCreacion());
//            System.out.println(entidad.getUsuarioModificacion());
//        }
//    }
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        // creadorId = 1 (AJUSTAR según tu BD)
//        Integer resultado = this.chatBO.insertar(
//                 1,                       // usuario (no se usa mucho en el BO, pero se pide)
//                "usuarioTest"          // usuarioCreacion
//        );
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        // AJUSTA chatId a uno que exista realmente
//        Integer resultado = this.chatBO.modificar(
//                1,              // chatId
//                1,              // estadoId
//                "usuarioTest",  // usuario (no se usa mucho en el BO, pero se pide)
//                null,           // usuarioCreacion
//                "modificadoTest"// usuarioModificacion
//        );
//        assertTrue(resultado != 0);
//    }
}
