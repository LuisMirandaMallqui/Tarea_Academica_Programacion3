package pe.edu.pucp.softinv.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

import pe.edu.pucp.softinv.daoImpl.NotificacionDAOImpl;

import pe.edu.pucp.softinv.dao.NotificacionDAO;
import pe.edu.pucp.softinv.model.NotificacionDTO;
import pe.edu.pucp.softinv.daoImpl.PersonasDAOImpl;
import pe.edu.pucp.softinv.dao.PersonasDAO;
import pe.edu.pucp.softinv.model.PersonasDTO;

@TestMethodOrder(OrderAnnotation.class)
public class NotificacionDAOTest {
    private final NotificacionDAO dao;
    private static Integer notifId;
    private static Integer personaId;
    private final PersonasDAO personasDAO = new PersonasDAOImpl();

    public NotificacionDAOTest() {
        this.dao = new NotificacionDAOImpl();
    }

    private Integer ensurePersona() {
        if (personaId != null) return personaId;
        PersonasDTO p = new PersonasDTO();
        p.setEs_administrador(Boolean.FALSE);
        p.setNombres("Ana");
        p.setPrimer_apellido("Gomez");
        p.setSegundo_apellido("Quispe");
        p.setCorreo_electronico("ana.gomez@pucp.edu.pe");
        p.setCodigo_universitario("20209999");
        p.setTipo_documento_id("DNI");
        p.setNumero_documento("87654321");
        p.setContrasenha("Secreta456!");
        personaId = personasDAO.insertar(p);
        return personaId;
    }

    @Test @Order(1)
    public void testInsertar() {
        System.out.println("insertar Notificacion");
        Integer pid = ensurePersona();
        NotificacionDTO n = new NotificacionDTO();
        n.setPersonaId(pid);
        n.setMensaje("Tu publicación fue aprobada");
        n.setFecha(Timestamp.from(Instant.now()));
        Integer id = dao.insertar(n);
        assertNotNull(id); assertTrue(id > 0);
        notifId = id;
    }

    @Test @Order(2)
    public void testObtenerPorId() {
        NotificacionDTO n = dao.obtenerPorId(notifId);
        assertNotNull(n);
        assertEquals("Tu publicación fue aprobada", n.getMensaje());
    }

    @Test @Order(3)
    public void testModificar() {
        NotificacionDTO n = dao.obtenerPorId(notifId);
        n.setMensaje("Tu publicación fue rechazada");
        Integer res = dao.modificar(n);
        assertTrue(res > 0);
        assertEquals("Tu publicación fue rechazada", dao.obtenerPorId(notifId).getMensaje());
    }

    @Test @Order(4)
    public void testListarTodos() {
        ArrayList<NotificacionDTO> lista = dao.listarTodos();
        assertNotNull(lista);
        assertTrue(lista.size() > 0);
    }

    @Test @Order(5)
    public void testEliminar() {
        NotificacionDTO n = new NotificacionDTO();
        n.setNotificacion_id(notifId);
        Integer res = dao.eliminar(n);
        assertTrue(res > 0);
    }
}
