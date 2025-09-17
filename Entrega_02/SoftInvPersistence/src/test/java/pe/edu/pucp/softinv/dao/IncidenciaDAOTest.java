package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

import pe.edu.pucp.softinv.daoImpl.IncidenciaDAOImpl;
import pe.edu.pucp.softinv.daoImpl.PersonasDAOImpl;
import pe.edu.pucp.softinv.model.IncidenciaDTO;
import pe.edu.pucp.softinv.model.PersonasDTO;

@TestMethodOrder(OrderAnnotation.class)
public class IncidenciaDAOTest {
    private final IncidenciaDAO dao;
    private final PersonasDAO personasDAO = new PersonasDAOImpl();
    private static Integer incId;
    private static Integer personaId;

    public IncidenciaDAOTest() {
        this.dao = new IncidenciaDAOImpl();
    }

    private Integer ensurePersona() {
        if (personaId != null) return personaId;
        PersonasDTO p = new PersonasDTO();
        p.setEsAdministador(Boolean.FALSE);
        p.setNombres("Luis");
        p.setPrimerApellido("Huaman");
        p.setSegundoApellido("Soto");
        p.setCorreoElectronico("luis.huaman@pucp.edu.pe");
        p.setCodigoUniversitario("20208888");
        p.setTipoDocumento("DNI");
        p.setNumeroDocumento("11223344");
        p.setContraseña("Clave789!");
        personaId = personasDAO.insertar(p);
        return personaId;
    }

    @Test @Order(1)
    public void testInsertar() {
        PersonasDTO persona = new PersonasDTO();
        persona.setPersonaId(ensurePersona());

        IncidenciaDTO i = new IncidenciaDTO();
        i.setPersonaId(persona);
        i.setDescripcion("No puedo actualizar mi publicacion");
        Integer id = dao.insertar(i);
        assertNotNull(id); assertTrue(id > 0);
        incId = id;
    }

    @Test @Order(2)
    public void testObtenerPorId() {
        IncidenciaDTO i = dao.obtenerPorId(incId);
        assertNotNull(i);
        assertEquals("No puedo actualizar mi publicacion", i.getDescripcion());
    }

    @Test @Order(3)
    public void testModificar() {
        IncidenciaDTO i = dao.obtenerPorId(incId);
        i.setDescripcion("No puedo eliminar mi publicacion");
        Integer res = dao.modificar(i);
        assertTrue(res > 0);
        assertEquals("No puedo eliminar mi publicacion", dao.obtenerPorId(incId).getDescripcion());
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
        i.setIncidenciaId(incId);
        Integer res = dao.eliminar(i);
        assertTrue(res > 0);
    }
}
