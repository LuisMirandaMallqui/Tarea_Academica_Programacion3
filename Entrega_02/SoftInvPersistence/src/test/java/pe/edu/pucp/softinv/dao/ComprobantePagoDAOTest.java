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

import pe.edu.pucp.softinv.daoImpl.ComprobantePagoDAOImpl;

import pe.edu.pucp.softinv.dao.ComprobantePagoDAO;
import pe.edu.pucp.softinv.model.ComprobantePagoDTO;
import pe.edu.pucp.softinv.daoImpl.PersonasDAOImpl;
import pe.edu.pucp.softinv.dao.PersonasDAO;
import pe.edu.pucp.softinv.model.PersonasDTO;

@TestMethodOrder(OrderAnnotation.class)
public class ComprobantePagoDAOTest {
    private final ComprobantePagoDAO dao;
    private static Integer compId;
    private static Integer personaId;
    private final PersonasDAO personasDAO = new PersonasDAOImpl();

    public ComprobantePagoDAOTest() {
        this.dao = new ComprobantePagoDAOImpl();
    }

    private Integer ensurePersona() {
        if (personaId != null) return personaId;
        PersonasDTO p = new PersonasDTO();
        p.setEs_administrador(Boolean.FALSE);
        p.setNombres("Carlos");
        p.setPrimer_apellido("Ramos");
        p.setSegundo_apellido("Diaz");
        p.setCorreo_electronico("carlos.ramos@pucp.edu.pe");
        p.setCodigo_universitario("20207777");
        p.setTipo_documento_id("DNI");
        p.setNumero_documento("55667788");
        p.setContrasenha("Clave123!");
        personaId = personasDAO.insertar(p);
        return personaId;
    }

    @Test @Order(1)
    public void testInsertar() {
        Integer pid = ensurePersona();
        ComprobantePagoDTO c = new ComprobantePagoDTO();
        c.setPersona_codigo(pid);
        c.setMetodo_pago_id(1); // Asegura que exista un método de pago con ID=1
        c.setFecha_pago(Timestamp.from(Instant.now()));
        c.setMonto_pago(new BigDecimal("25.50"));
        c.setNumero_transaccion(10001);
        c.setDescripcion("Compra de material");
        Integer id = dao.insertar(c);
        assertNotNull(id); assertTrue(id > 0);
        compId = id;
    }

    @Test @Order(2)
    public void testObtenerPorId() {
        ComprobantePagoDTO c = dao.obtenerPorId(compId);
        assertNotNull(c);
        assertEquals(new BigDecimal("25.50"), c.getMonto_pago());
    }

    @Test @Order(3)
    public void testModificar() {
        ComprobantePagoDTO c = dao.obtenerPorId(compId);
        c.setMonto_pago(new BigDecimal("30.00"));
        Integer res = dao.modificar(c);
        assertTrue(res > 0);
        assertEquals(new BigDecimal("30.00"), dao.obtenerPorId(compId).getMonto_pago());
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
        c.setComprobante_de_pago_id(compId);
        Integer res = dao.eliminar(c);
        assertTrue(res > 0);
    }
}
