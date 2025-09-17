/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softinv.model.NotificacionDTO;

/**
 *
 * @author adria
 */
@Disabled("Prototype tests disabled")
public class NotificacionDAOTest {
    
    public NotificacionDAOTest() {
    }

    /**
     * Test of insertar method, of class NotificacionDAO.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        NotificacionDTO obj = null;
        NotificacionDAO instance = new NotificacionDAOImpl();
        Integer expResult = null;
        Integer result = instance.insertar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPorId method, of class NotificacionDAO.
     */
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        Integer notificacionId = null;
        NotificacionDAO instance = new NotificacionDAOImpl();
        NotificacionDTO expResult = null;
        NotificacionDTO result = instance.obtenerPorId(notificacionId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodos method, of class NotificacionDAO.
     */
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        NotificacionDAO instance = new NotificacionDAOImpl();
        ArrayList<NotificacionDTO> expResult = null;
        ArrayList<NotificacionDTO> result = instance.listarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class NotificacionDAO.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        NotificacionDTO obj = null;
        NotificacionDAO instance = new NotificacionDAOImpl();
        Integer expResult = null;
        Integer result = instance.modificar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class NotificacionDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        NotificacionDTO obj = null;
        NotificacionDAO instance = new NotificacionDAOImpl();
        Integer expResult = null;
        Integer result = instance.eliminar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class NotificacionDAOImpl implements NotificacionDAO {

        public Integer insertar(NotificacionDTO obj) {
            return null;
        }

        public NotificacionDTO obtenerPorId(Integer notificacionId) {
            return null;
        }

        public ArrayList<NotificacionDTO> listarTodos() {
            return null;
        }

        public Integer modificar(NotificacionDTO obj) {
            return null;
        }

        public Integer eliminar(NotificacionDTO obj) {
            return null;
        }
    }
    
}
