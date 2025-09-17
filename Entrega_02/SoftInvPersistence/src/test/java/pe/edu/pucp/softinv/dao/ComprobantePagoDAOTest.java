/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softinv.model.ComprobantePagoDTO;

/**
 *
 * @author adria
 */
@Disabled("Prototype tests disabled")
public class ComprobantePagoDAOTest {
    
    public ComprobantePagoDAOTest() {
    }

    /**
     * Test of insertar method, of class ComprobantePagoDAO.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ComprobantePagoDTO obj = null;
        ComprobantePagoDAO instance = new ComprobantePagoDAOImpl();
        Integer expResult = null;
        Integer result = instance.insertar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPorId method, of class ComprobantePagoDAO.
     */
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        Integer comprobanteDePagoId = null;
        ComprobantePagoDAO instance = new ComprobantePagoDAOImpl();
        ComprobantePagoDTO expResult = null;
        ComprobantePagoDTO result = instance.obtenerPorId(comprobanteDePagoId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodos method, of class ComprobantePagoDAO.
     */
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ComprobantePagoDAO instance = new ComprobantePagoDAOImpl();
        ArrayList<ComprobantePagoDTO> expResult = null;
        ArrayList<ComprobantePagoDTO> result = instance.listarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class ComprobantePagoDAO.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ComprobantePagoDTO obj = null;
        ComprobantePagoDAO instance = new ComprobantePagoDAOImpl();
        Integer expResult = null;
        Integer result = instance.modificar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class ComprobantePagoDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ComprobantePagoDTO obj = null;
        ComprobantePagoDAO instance = new ComprobantePagoDAOImpl();
        Integer expResult = null;
        Integer result = instance.eliminar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ComprobantePagoDAOImpl implements ComprobantePagoDAO {

        public Integer insertar(ComprobantePagoDTO obj) {
            return null;
        }

        public ComprobantePagoDTO obtenerPorId(Integer comprobanteDePagoId) {
            return null;
        }

        public ArrayList<ComprobantePagoDTO> listarTodos() {
            return null;
        }

        public Integer modificar(ComprobantePagoDTO obj) {
            return null;
        }

        public Integer eliminar(ComprobantePagoDTO obj) {
            return null;
        }
    }
    
}
