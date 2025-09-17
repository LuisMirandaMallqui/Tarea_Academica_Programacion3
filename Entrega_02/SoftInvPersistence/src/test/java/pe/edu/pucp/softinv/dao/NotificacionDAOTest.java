package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

import pe.edu.pucp.softinv.daoImpl.NotificacionDAOImpl;
import pe.edu.pucp.softinv.daoImpl.PersonasDAOImpl;
import pe.edu.pucp.softinv.model.NotificacionDTO;
import pe.edu.pucp.softinv.model.PersonasDTO;

@TestMethodOrder(OrderAnnotation.class)
public class NotificacionDAOTest {
    private final NotificacionDAO dao;
    private final PersonasDAO personasDAO = new PersonasDAOImpl();
    private static Integer notifId;
    private static Integer personaId;

    public NotificacionDAOTest() {
        this.dao = new NotificacionDAOImpl();
    }

    private Integer ensurePersona() {
        if (personaId != null) return personaId;
        PersonasDTO p = new PersonasDTO();
        p.setEsAdministador(Boolean.FALSE);
        p.setNombres("Ana");
        p.setPrimerApellido("Gomez");
        p.setSegundoApellido("Quispe");
        p.setCorreoElectronico("ana.gomez@pucp.edu.pe");
        p.setCodigoUniversitario("20209999");
        p.setTipoDocumento("DNI");
        p.setNumeroDocumento("87654321");
        p.setContraseña("Secreta456!");
        personaId = personasDAO.insertar(p);
        return personaId;
    }

    @Test @Order(1)
    public void testInsertar() {
        System.out.println("insertar Notificacion");
        PersonasDTO persona = new PersonasDTO();
        persona.setPersonaId(ensurePersona());

        NotificacionDTO n = new NotificacionDTO();
        n.setPersonaId(persona);
        n.setMensaje("Tu publicacion fue aprobada");
        n.setFecha(LocalDateTime.now());
        Integer id = dao.insertar(n);
        assertNotNull(id); assertTrue(id > 0);
        notifId = id;
    }

    @Test @Order(2)
    public void testObtenerPorId() {
        NotificacionDTO n = dao.obtenerPorId(notifId);
        assertNotNull(n);
        assertEquals("Tu publicacion fue aprobada", n.getMensaje());
    }

    @Test @Order(3)
    public void testModificar() {
        NotificacionDTO n = dao.obtenerPorId(notifId);
        n.setMensaje("Tu publicacion fue rechazada");
        Integer res = dao.modificar(n);
        assertTrue(res > 0);
        assertEquals("Tu publicacion fue rechazada", dao.obtenerPorId(notifId).getMensaje());
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
        n.setNotificacionId(notifId);
        Integer res = dao.eliminar(n);
        assertTrue(res > 0);
    }
}
