/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softinv.model.PublicacionDTO;

/**
 *
 * @author adria
 */
@Disabled("Prototype tests disabled")
public class PublicacionDAOTest {
    
    public PublicacionDAOTest() {
    }

    /**
     * Test of insertar method, of class PublicacionDAO.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        PublicacionDTO obj = null;
        PublicacionDAO instance = new PublicacionDAOImpl();
        Integer expResult = null;
        Integer result = instance.insertar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPorId method, of class PublicacionDAO.
     */
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        Integer publicacionId = null;
        PublicacionDAO instance = new PublicacionDAOImpl();
        PublicacionDTO expResult = null;
        PublicacionDTO result = instance.obtenerPorId(publicacionId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodos method, of class PublicacionDAO.
     */
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        PublicacionDAO instance = new PublicacionDAOImpl();
        ArrayList<PublicacionDTO> expResult = null;
        ArrayList<PublicacionDTO> result = instance.listarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class PublicacionDAO.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        PublicacionDTO obj = null;
        PublicacionDAO instance = new PublicacionDAOImpl();
        Integer expResult = null;
        Integer result = instance.modificar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class PublicacionDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        PublicacionDTO obj = null;
        PublicacionDAO instance = new PublicacionDAOImpl();
        Integer expResult = null;
        Integer result = instance.eliminar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PublicacionDAOImpl implements PublicacionDAO {

        public Integer insertar(PublicacionDTO obj) {
            return null;
        }

        public PublicacionDTO obtenerPorId(Integer publicacionId) {
            return null;
        }

        public ArrayList<PublicacionDTO> listarTodos() {
            return null;
        }

        public Integer modificar(PublicacionDTO obj) {
            return null;
        }

        public Integer eliminar(PublicacionDTO obj) {
            return null;
        }
    }
    
}
