package pe.edu.pucp.squirlearn.dao.chat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.chat.MensajeDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.ChatDto;
import pe.edu.pucp.squirlearn.model.chat.EstadoMensajeDto;
import pe.edu.pucp.squirlearn.model.chat.MensajeDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class MensajeDaoTest {

    private MensajeDao mensajeDAO;

    public MensajeDaoTest() {
        this.mensajeDAO = new MensajeDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ChatDto chat = new ChatDto();
//        chat.setChatId(1);
//        EstadoMensajeDto estado = new EstadoMensajeDto();
//        estado.setEstadoMsjId(1);
//        PersonaDto persona = new PersonaDto();
//        persona.setPersonaId(1);
//
//        MensajeDto mensaje = new MensajeDto();
//        mensaje.setChat(chat);
//        mensaje.setEstadoMensaje(estado);
//        mensaje.setPersona(persona);
//        mensaje.setFechaEnvio("2025-02-12 10:00:00");
//        mensaje.setMensaje("Hola desde test");
//
//        Integer resultado = this.mensajeDAO.insertar(mensaje);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        MensajeDto mensaje = this.mensajeDAO.obtenerPorId(1);
//        if (mensaje != null) {
//            System.out.println(mensaje.getMensajeId());
//            System.out.println(mensaje.getMensaje());
//            System.out.println(mensaje.getFechaEnvio());
//            if (mensaje.getChat() != null) System.out.println(mensaje.getChat().getChatId());
//            if (mensaje.getPersona() != null) System.out.println(mensaje.getPersona().getPersonaId());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<MensajeDto> lista = this.mensajeDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            MensajeDto mensaje = lista.get(i);
//            System.out.println("Dato:");
//            System.out.println(mensaje.getMensajeId());
//            System.out.println(mensaje.getMensaje());
//        }
//    }

//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ChatDto chat = new ChatDto();
//        chat.setChatId(1);
//        EstadoMensajeDto estado = new EstadoMensajeDto();
//        estado.setEstadoMsjId(1);
//        PersonaDto persona = new PersonaDto();
//        persona.setPersonaId(1);
//
//        MensajeDto mensaje = new MensajeDto();
//        mensaje.setChat(chat);
//        mensaje.setEstadoMensaje(estado);
//        mensaje.setPersona(persona);
//        mensaje.setMensajeId(2);
//        mensaje.setMensaje("Mensaje modificado");
//        mensaje.setFechaEnvio("2025-02-12 11:00:00");
//        mensaje.setFechaLeido("2025-02-12 11:05:00");
//        Integer resultado = this.mensajeDAO.modificar(mensaje);
//        assertTrue(resultado != 0);
//    }

//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        MensajeDto mensaje = new MensajeDto();
//        mensaje.setMensajeId(3);
//        this.mensajeDAO.eliminar(mensaje);
//    }
}
