package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

import pe.edu.pucp.softinv.daoImpl.ComprobantePagoDAOImpl;
import pe.edu.pucp.softinv.daoImpl.PersonasDAOImpl;
import pe.edu.pucp.softinv.model.ComprobantePagoDTO;
import pe.edu.pucp.softinv.model.PersonasDTO;

@TestMethodOrder(OrderAnnotation.class)
public class ComprobantePagoDAOTest {
    private final ComprobantePagoDAO dao;
    private final PersonasDAO personasDAO = new PersonasDAOImpl();
    private static Integer compId;
    private static Integer personaId;

    public ComprobantePagoDAOTest() {
        this.dao = new ComprobantePagoDAOImpl();
    }

    private Integer ensurePersona() {
        if (personaId != null) return personaId;
        PersonasDTO p = new PersonasDTO();
        p.setEsAdministador(Boolean.FALSE);
        p.setNombres("Carlos");
        p.setPrimerApellido("Ramos");
        p.setSegundoApellido("Diaz");
        p.setCorreoElectronico("carlos.ramos@pucp.edu.pe");
        p.setCodigoUniversitario("20207777");
        p.setTipoDocumento("DNI");
        p.setNumeroDocumento("55667788");
        p.setContraseña("Clave123!");
        personaId = personasDAO.insertar(p);
        return personaId;
    }

    @Test @Order(1)
    public void testInsertar() {
        PersonasDTO persona = new PersonasDTO();
        persona.setPersonaId(ensurePersona());

        ComprobantePagoDTO c = new ComprobantePagoDTO();
        c.setPersonaId(persona);
        c.setFecha(LocalDateTime.now());
        c.setMontoPago(25.50);
        c.setNumeroTransaccion(10001);
        c.setDescripcion("Compra de material");
        Integer id = dao.insertar(c);
        assertNotNull(id); assertTrue(id > 0);
        compId = id;
    }

    @Test @Order(2)
    public void testObtenerPorId() {
        ComprobantePagoDTO c = dao.obtenerPorId(compId);
        assertNotNull(c);
        assertEquals(25.50, c.getMontoPago(), 0.001);
    }

    @Test @Order(3)
    public void testModificar() {
        ComprobantePagoDTO c = dao.obtenerPorId(compId);
        c.setMontoPago(30.00);
        Integer res = dao.modificar(c);
        assertTrue(res > 0);
        assertEquals(30.00, dao.obtenerPorId(compId).getMontoPago(), 0.001);
    }

    @Test @Order(4)
    public void testListarTodos() {
        ArrayList<ComprobantePagoDTO> lista = dao.listarTodos();
        assertNotNull(lista);
        assertTrue(lista.size() > 0);
    }

    @Test @Order(5)
    public void testEliminar() {
        ComprobantePagoDTO c = new ComprobantePagoDTO();
        c.setComprobanteDePagoId(compId);
        Integer res = dao.eliminar(c);
        assertTrue(res > 0);
    }
}
