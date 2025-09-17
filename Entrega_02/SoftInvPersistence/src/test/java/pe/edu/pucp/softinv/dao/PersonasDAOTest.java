/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softinv.model.PersonasDTO;

/**
 *
 * @author adria
 */
@Disabled("Prototype tests disabled")
public class PersonasDAOTest {
    
    public PersonasDAOTest() {
    }

    /**
     * Test of insertar method, of class PersonasDAO.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        PersonasDTO obj = null;
        PersonasDAO instance = new PersonasDAOImpl();
        Integer expResult = null;
        Integer result = instance.insertar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPorId method, of class PersonasDAO.
     */
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        Integer personaId = null;
        PersonasDAO instance = new PersonasDAOImpl();
        PersonasDTO expResult = null;
        PersonasDTO result = instance.obtenerPorId(personaId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodos method, of class PersonasDAO.
     */
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        PersonasDAO instance = new PersonasDAOImpl();
        ArrayList<PersonasDTO> expResult = null;
        ArrayList<PersonasDTO> result = instance.listarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificar method, of class PersonasDAO.
     */
    @Test
    public void testModificar() {
        System.out.println("modificar");
        PersonasDTO obj = null;
        PersonasDAO instance = new PersonasDAOImpl();
        Integer expResult = null;
        Integer result = instance.modificar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class PersonasDAO.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        PersonasDTO obj = null;
        PersonasDAO instance = new PersonasDAOImpl();
        Integer expResult = null;
        Integer result = instance.eliminar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PersonasDAOImpl implements PersonasDAO {

        public Integer insertar(PersonasDTO obj) {
            return null;
        }

        public PersonasDTO obtenerPorId(Integer personaId) {
            return null;
        }

        public ArrayList<PersonasDTO> listarTodos() {
            return null;
        }

        public Integer modificar(PersonasDTO obj) {
            return null;
        }

        public Integer eliminar(PersonasDTO obj) {
            return null;
        }
    }
    
}
