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

import pe.edu.pucp.softinv.daoImpl.PublicacionDAOImpl;

import pe.edu.pucp.softinv.dao.PublicacionDAO;
import pe.edu.pucp.softinv.model.PublicacionDTO;

import pe.edu.pucp.softinv.dao.EstadoPublicacionDAO;
import pe.edu.pucp.softinv.daoImpl.EstadoPublicacionDAOImpl;
import pe.edu.pucp.softinv.model.EstadoPublicacionDTO;

import pe.edu.pucp.softinv.dao.PersonasDAO;
import pe.edu.pucp.softinv.daoImpl.PersonasDAOImpl;
import pe.edu.pucp.softinv.model.PersonasDTO;

@TestMethodOrder(OrderAnnotation.class)
public class PublicacionDAOTest {
    private final PublicacionDAO dao;
    private final PersonasDAO personasDAO = new PersonasDAOImpl();
    private final EstadoPublicacionDAO estadoDAO = new EstadoPublicacionDAOImpl();
    private static Integer pubId;
    private static Integer personaId;
    private static Integer estadoId;

    public PublicacionDAOTest() {
        this.dao = new PublicacionDAOImpl();
    }

    private Integer ensurePersona() {
        if (personaId != null) return personaId;
        PersonasDTO p = new PersonasDTO();
        p.setEs_administrador(Boolean.FALSE);
        p.setNombres("Mario");
        p.setPrimer_apellido("Vega");
        p.setSegundo_apellido("Salas");
        p.setCorreo_electronico("mario.vega@pucp.edu.pe");
        p.setCodigo_universitario("20206666");
        p.setTipo_documento_id("DNI");
        p.setNumero_documento("66778899");
        p.setContrasenha("Pass123!");
        personaId = personasDAO.insertar(p);
        return personaId;
    }

    private Integer ensureEstado() {
        if (estadoId != null) return estadoId;
        EstadoPublicacionDTO e = new EstadoPublicacionDTO();
        e.setDescripcion("Activa");
        e.setFecha_ingreso(Timestamp.from(Instant.now()));
        estadoId = estadoDAO.insertar(e);
        return estadoId;
    }

    @Test @Order(1)
    public void testInsertar() {
        Integer pid = ensurePersona();
        Integer eid = ensureEstado();

        PublicacionDTO p = new PublicacionDTO();
        p.setMaterial_material_id(1); // Asegúrate de tener MATERIAL con ID=1 y sus maestros
        p.setEstado_publicacion_id(eid);
        p.setPersona_codigo(pid);
        p.setValoracion(5);
        p.setFecha_publicacion(Timestamp.from(Instant.now()));
        p.setPrecio(new BigDecimal("15.90"));

        Integer id = dao.insertar(p);
        assertNotNull(id); assertTrue(id > 0);
        pubId = id;
    }

    @Test @Order(2)
    public void testObtenerPorId() {
        PublicacionDTO p = dao.obtenerPorId(pubId);
        assertNotNull(p);
        assertEquals(5, p.getValoracion());
    }

    @Test @Order(3)
    public void testModificar() {
        PublicacionDTO p = dao.obtenerPorId(pubId);
        p.setValoracion(4);
        Integer res = dao.modificar(p);
        assertTrue(res > 0);
        assertEquals(4, dao.obtenerPorId(pubId).getValoracion());
    }

    @Test @Order(4)
    public void testListarTodos() {
        ArrayList<PublicacionDTO> lista = dao.listarTodos();
        assertNotNull(lista);
        assertTrue(lista.size() > 0);
    }

    @Test @Order(5)
    public void testEliminar() {
        PublicacionDTO p = new PublicacionDTO();
        p.setPublicacion_id(pubId);
        Integer res = dao.eliminar(p);
        assertTrue(res > 0);
    }
}

