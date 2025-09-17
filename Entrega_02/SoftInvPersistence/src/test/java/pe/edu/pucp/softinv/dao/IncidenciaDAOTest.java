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

import pe.edu.pucp.softinv.daoImpl.IncidenciaDAOImpl;

import pe.edu.pucp.softinv.dao.IncidenciaDAO;
import pe.edu.pucp.softinv.model.IncidenciaDTO;
import pe.edu.pucp.softinv.daoImpl.PersonasDAOImpl;
import pe.edu.pucp.softinv.dao.PersonasDAO;
import pe.edu.pucp.softinv.model.PersonasDTO;

@TestMethodOrder(OrderAnnotation.class)
public class IncidenciaDAOTest {
    private final IncidenciaDAO dao;
    private static Integer incId;
    private static Integer personaId;
    private final PersonasDAO personasDAO = new PersonasDAOImpl();

    public IncidenciaDAOTest() {
        this.dao = new IncidenciaDAOImpl();
    }

    private Integer ensurePersona() {
        if (personaId != null) return personaId;
        PersonasDTO p = new PersonasDTO();
        p.setEs_administrador(Boolean.FALSE);
        p.setNombres("Luis");
        p.setPrimer_apellido("Huaman");
        p.setSegundo_apellido("Soto");
        p.setCorreo_electronico("luis.huaman@pucp.edu.pe");
        p.setCodigo_universitario("20208888");
        p.setTipo_documento_id("DNI");
        p.setNumero_documento("11223344");
        p.setContrasenha("Clave789!");
        personaId = personasDAO.insertar(p);
        return personaId;
    }

    @Test @Order(1)
    public void testInsertar() {
        Integer pid = ensurePersona();
        IncidenciaDTO i = new IncidenciaDTO();
        i.setPersona_codigo(pid);
        i.setDescripcion("No puedo actualizar mi publicación");
        Integer id = dao.insertar(i);
        assertNotNull(id); assertTrue(id > 0);
        incId = id;
    }

    @Test @Order(2)
    public void testObtenerPorId() {
        IncidenciaDTO i = dao.obtenerPorId(incId);
        assertNotNull(i);
        assertEquals("No puedo actualizar mi publicación", i.getDescripcion());
    }

    @Test @Order(3)
    public void testModificar() {
        IncidenciaDTO i = dao.obtenerPorId(incId);
        i.setDescripcion("No puedo eliminar mi publicación");
        Integer res = dao.modificar(i);
        assertTrue(res > 0);
        assertEquals("No puedo eliminar mi publicación", dao.obtenerPorId(incId).getDescripcion());
    }

    @Test @Order(4)
    public void testListarTodos() {
        ArrayList<IncidenciaDTO> lista = dao.listarTodos();
        assertNotNull(lista);
        assertTrue(lista.size() > 0);
    }

    @Test @Order(5)
    public void testEliminar() {
        IncidenciaDTO i = new IncidenciaDTO();
        i.setIncidencia_id(incId);
        Integer res = dao.eliminar(i);
        assertTrue(res > 0);
    }
}

