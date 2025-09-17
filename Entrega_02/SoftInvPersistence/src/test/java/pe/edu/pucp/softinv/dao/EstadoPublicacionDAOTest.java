/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softinv.model.EstadoPublicacionDTO;

/**
 *
 * @author adria
 */
@Disabled("Prototype tests disabled")
public class EstadoPublicacionDAOTest {
    
    public EstadoPublicacionDAOTest() {
    }

    /**
     * Test of insertar method, of class EstadoPublicacionDAO.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        EstadoPublicacionDTO obj = null;
        EstadoPublicacionDAO instance = new EstadoPublicacionDAOImpl();
        Integer expResult = null;
        Integer result = instance.insertar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPorId method, of class EstadoPublicacionDAO.
     */
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        Integer estadoPublicacionId = null;
        EstadoPublicacionDAO instance = new EstadoPublicacionDAOImpl();
        EstadoPublicacionDTO expResult = null;
        EstadoPublicacionDTO result = instance.obtenerPorId(estadoPublicacionId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodos method, of class EstadoPublicacionDAO.
     */
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        EstadoPublicacionDAO instance = new EstadoPublicacionDAOImpl();
        ArrayList<EstadoPublicacionDTO> expResult = null;
        ArrayList<EstadoPublicacionDTO> result = instance.listarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class EstadoPublicacionDAO.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        EstadoPublicacionDTO obj = null;
        EstadoPublicacionDAO instance = new EstadoPublicacionDAOImpl();
        Integer expResult = null;
        Integer result = instance.modificar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class EstadoPublicacionDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        EstadoPublicacionDTO obj = null;
        EstadoPublicacionDAO instance = new EstadoPublicacionDAOImpl();
        Integer expResult = null;
        Integer result = instance.eliminar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class EstadoPublicacionDAOImpl implements EstadoPublicacionDAO {

        public Integer insertar(EstadoPublicacionDTO obj) {
            return null;
        }

        public EstadoPublicacionDTO obtenerPorId(Integer estadoPublicacionId) {
            return null;
        }

        public ArrayList<EstadoPublicacionDTO> listarTodos() {
            return null;
        }

        public Integer modificar(EstadoPublicacionDTO obj) {
            return null;
        }

        public Integer eliminar(EstadoPublicacionDTO obj) {
            return null;
        }
    }
    
}
