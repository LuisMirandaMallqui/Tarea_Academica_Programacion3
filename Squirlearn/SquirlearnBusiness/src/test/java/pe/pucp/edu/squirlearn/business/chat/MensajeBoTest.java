package pe.pucp.edu.squirlearn.business.chat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.chat.MensajeDto;

public class MensajeBoTest {

    private MensajeBo mensajeBO;

    public MensajeBoTest() {
        this.mensajeBO = new MensajeBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<MensajeDto> lista = this.mensajeBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getMensajeId());
//            System.out.println(lista.get(i).getPersona().getPersonaId());
//            System.out.println(lista.get(i).getChat().getChatId());
//            System.out.println(lista.get(i).getFechaEnvio());
//            System.out.println(lista.get(i).getFechaLeido());
//            System.out.println(lista.get(i).getEstadoMensaje().getEstadoMsjId());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        MensajeDto entidad = this.mensajeBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getMensajeId());
//            System.out.println(entidad.getPersona().getPersonaId());
//            System.out.println(entidad.getChat().getChatId());
//            System.out.println(entidad.getFechaEnvio());
//            System.out.println(entidad.getFechaLeido());
//            System.out.println(entidad.getEstadoMensaje().getEstadoMsjId());
//        }
//    }
//     @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        // chatId = 1, personaId = 1 (AJUSTAR según tu BD)
//        Integer resultado = this.mensajeBO.insertar(
//                1,                      // chatId
//                "Mensaje de prueba",    // mensaje
//                1                       // personaId
//        );
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        // AJUSTA mensajeId (id) a uno existente y demás datos según tu BD
//        Integer resultado = this.mensajeBO.modificar(
//                2,                          // id del mensaje
//                1,                          // chatId
//                "Mensaje modificado",       // mensaje
//                1,                          // estadoId
//                1,                          // personaId
//                "2025-02-12 11:00:00",      // fechaEnvio
//                "2025-02-12 11:05:00"       // fechaLeido
//        );
//        assertTrue(resultado != 0);
//    }
}
