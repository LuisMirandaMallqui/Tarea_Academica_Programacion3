package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

import pe.edu.pucp.softinv.daoImpl.PersonasDAOImpl;
import pe.edu.pucp.softinv.model.PersonasDTO;

@TestMethodOrder(OrderAnnotation.class)
public class PersonasDAOTest {
    private final PersonasDAO dao;
    private static Integer personaId;

    public PersonasDAOTest() {
        this.dao = new PersonasDAOImpl();
    }

    @Test @Order(1)
    public void testInsertar() {
        System.out.println("insertar Personas");
        PersonasDTO p = new PersonasDTO();
        p.setEsAdministador(Boolean.FALSE);
        p.setNombres("Juan");
        p.setPrimerApellido("Perez");
        p.setSegundoApellido("Lopez");
        p.setCorreoElectronico("juan.perez@pucp.edu.pe");
        p.setCodigoUniversitario("20201234");
        p.setTipoDocumento("DNI");
        p.setNumeroDocumento("12345678");
        p.setContraseña("Secreta123!");
        Integer id = dao.insertar(p);
        assertNotNull(id);
        assertTrue(id > 0);
        personaId = id;
        System.out.println("Nuevo personaId = " + personaId);
    }

    @Test @Order(2)
    public void testObtenerPorId() {
        System.out.println("obtener Personas por id");
        assertNotNull(personaId);
        PersonasDTO p = dao.obtenerPorId(personaId);
        assertNotNull(p);
        assertEquals("Juan", p.getNombres());
    }

    @Test @Order(3)
    public void testModificar() {
        System.out.println("modificar Personas");
        PersonasDTO p = dao.obtenerPorId(personaId);
        p.setNombres("Juan Mod");
        Integer res = dao.modificar(p);
        assertNotNull(res);
        assertTrue(res > 0);
        PersonasDTO up = dao.obtenerPorId(personaId);
        assertEquals("Juan Mod", up.getNombres());
    }

    @Test @Order(4)
    public void testListarTodos() {
        System.out.println("listar Personas");
        ArrayList<PersonasDTO> lista = dao.listarTodos();
        assertNotNull(lista);
        assertTrue(lista.size() > 0);
    }

    @Test @Order(5)
    public void testEliminar() {
        System.out.println("eliminar Personas");
        PersonasDTO p = new PersonasDTO();
        p.setPersonaId(personaId);
        Integer res = dao.eliminar(p);
        assertNotNull(res);
        assertTrue(res > 0);
    }
}
