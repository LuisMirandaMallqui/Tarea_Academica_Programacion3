package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

import pe.edu.pucp.softinv.daoImpl.EstadoPublicacionDAOImpl;
import pe.edu.pucp.softinv.model.EstadoPublicacionDTO;

@TestMethodOrder(OrderAnnotation.class)
public class EstadoPublicacionDAOTest {
    private final EstadoPublicacionDAO dao;
    private static Integer estadoId;

    public EstadoPublicacionDAOTest() {
        this.dao = new EstadoPublicacionDAOImpl();
    }

    @Test @Order(1)
    public void testInsertar() {
        System.out.println("insertar EstadoPublicacion");
        EstadoPublicacionDTO e = new EstadoPublicacionDTO();
        e.setDescripcion("Activo");
        e.setFechaIngreso(LocalDateTime.now());
        Integer id = dao.insertar(e);
        assertNotNull(id);
        assertTrue(id > 0);
        estadoId = id;
    }

    @Test @Order(2)
    public void testObtenerPorId() {
        System.out.println("obtener EstadoPublicacion por id");
        EstadoPublicacionDTO e = dao.obtenerPorId(estadoId);
        assertNotNull(e);
        assertEquals("Activo", e.getDescripcion());
    }

    @Test @Order(3)
    public void testModificar() {
        System.out.println("modificar EstadoPublicacion");
        EstadoPublicacionDTO e = dao.obtenerPorId(estadoId);
        e.setDescripcion("Pausado");
        Integer res = dao.modificar(e);
        assertNotNull(res);
        assertTrue(res > 0);
        assertEquals("Pausado", dao.obtenerPorId(estadoId).getDescripcion());
    }

    @Test @Order(4)
    public void testListarTodos() {
        System.out.println("listar EstadoPublicacion");
        ArrayList<EstadoPublicacionDTO> lista = dao.listarTodos();
        assertNotNull(lista);
        assertTrue(lista.size() > 0);
    }

    @Test @Order(5)
    public void testEliminar() {
        System.out.println("eliminar EstadoPublicacion");
        EstadoPublicacionDTO e = new EstadoPublicacionDTO();
        e.setEstadoPublicacionId(estadoId);
        Integer res = dao.eliminar(e);
        assertNotNull(res);
        assertTrue(res > 0);
    }
}
