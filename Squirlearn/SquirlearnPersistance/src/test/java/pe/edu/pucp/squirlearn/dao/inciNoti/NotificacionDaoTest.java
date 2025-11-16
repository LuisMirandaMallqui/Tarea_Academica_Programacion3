package pe.edu.pucp.squirlearn.dao.inciNoti;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.inciNoti.NotificacionDaoImpl;
import pe.edu.pucp.squirlearn.model.inciNoti.NotificacionDto;
import pe.edu.pucp.squirlearn.model.inciNoti.MotivoDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class NotificacionDaoTest {

    private NotificacionDao notificacionDAO;

    public NotificacionDaoTest() {
        this.notificacionDAO = new NotificacionDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        PersonaDto persona = new PersonaDto();
//        persona.setPersonaId(1);
//        MotivoDto motivo = new MotivoDto();
//        motivo.setMotivoId(1);
//
//        NotificacionDto n = new NotificacionDto();
//        n.setPersona(persona);
//        n.setMotivo(motivo);
//        n.setMensaje("Notificación de prueba");
//        n.setFecha("2025-11-21");
//
//        Integer resultado = this.notificacionDAO.insertar(n);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        NotificacionDto n = this.notificacionDAO.obtenerPorId(1);
//        if (n != null) {
//            System.out.println(n.getNotificacionId());
//            System.out.println(n.getMensaje());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<NotificacionDto> lista = this.notificacionDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            NotificacionDto n = lista.get(i);
//            System.out.println("Dato:");
//            System.out.println(n.getNotificacionId());
//            System.out.println(n.getMensaje());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        NotificacionDto n = new NotificacionDto();
//        n.setNotificacionId(10);
//        PersonaDto persona = new PersonaDto();
//        persona.setPersonaId(1);
//        MotivoDto motivo = new MotivoDto();
//        motivo.setMotivoId(1);
//        n.setPersona(persona);
//        n.setMotivo(motivo);
//        n.setMensaje("Notificación modificada");
//        n.setFecha("2025-11-19");
//        Integer resultado = this.notificacionDAO.modificar(n);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        NotificacionDto n = new NotificacionDto();
//        n.setNotificacionId(1);
//        this.notificacionDAO.eliminar(n);
//    }
}
