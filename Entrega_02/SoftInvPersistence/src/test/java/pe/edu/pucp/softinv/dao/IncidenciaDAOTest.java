/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softinv.model.IncidenciaDTO;

/**
 *
 * @author adria
 */
@Disabled("Prototype tests disabled")
public class IncidenciaDAOTest {
    
    public IncidenciaDAOTest() {
    }

    /**
     * Test of insertar method, of class IncidenciaDAO.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        IncidenciaDTO obj = null;
        IncidenciaDAO instance = new IncidenciaDAOImpl();
        Integer expResult = null;
        Integer result = instance.insertar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPorId method, of class IncidenciaDAO.
     */
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        Integer incidenciaId = null;
        IncidenciaDAO instance = new IncidenciaDAOImpl();
        IncidenciaDTO expResult = null;
        IncidenciaDTO result = instance.obtenerPorId(incidenciaId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodos method, of class IncidenciaDAO.
     */
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        IncidenciaDAO instance = new IncidenciaDAOImpl();
        ArrayList<IncidenciaDTO> expResult = null;
        ArrayList<IncidenciaDTO> result = instance.listarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class IncidenciaDAO.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        IncidenciaDTO obj = null;
        IncidenciaDAO instance = new IncidenciaDAOImpl();
        Integer expResult = null;
        Integer result = instance.modificar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class IncidenciaDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        IncidenciaDTO obj = null;
        IncidenciaDAO instance = new IncidenciaDAOImpl();
        Integer expResult = null;
        Integer result = instance.eliminar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IncidenciaDAOImpl implements IncidenciaDAO {

        public Integer insertar(IncidenciaDTO obj) {
            return null;
        }

        public IncidenciaDTO obtenerPorId(Integer incidenciaId) {
            return null;
        }

        public ArrayList<IncidenciaDTO> listarTodos() {
            return null;
        }

        public Integer modificar(IncidenciaDTO obj) {
            return null;
        }

        public Integer eliminar(IncidenciaDTO obj) {
            return null;
        }
    }
    
}
