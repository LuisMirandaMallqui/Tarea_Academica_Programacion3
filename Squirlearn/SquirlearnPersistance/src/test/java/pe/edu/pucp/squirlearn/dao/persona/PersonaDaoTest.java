package pe.edu.pucp.squirlearn.dao.persona;

import java.util.ArrayList;
import java.sql.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.persona.PersonaDaoImpl;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class PersonaDaoTest {
    
//    private PersonaDao personaDao;    
//    
//    public PersonaDaoTest() {
//        this.personaDao = new PersonaDaoImpl();        
//    }
//    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaPersonaId = new ArrayList<>();
//        insertarPersonas(listaPersonaId);
//        eliminarTodo();
//    }
//    
//    private void insertarPersonas(ArrayList<Integer> listaPersonaId) {
//        PersonaDto persona = new PersonaDto();
//        persona.setPersonaId(1);
//        persona.setNombres("Lorem ipsum nombres");
//        persona.setPrimerApellido("Lorem ipsum primerApellido");
//        persona.setSegundoApellido("Lorem ipsum segundoApellido");
//        persona.setCodigo("Lorem ipsum codigo");
//        persona.setCorreo("Lorem ipsum correo");
//        persona.setContrasena("Lorem ipsum contrasena");
//        persona.setFechaCreacion(new Date(System.currentTimeMillis()));
//        persona.setUsuarioCreacion(1);
//        persona.setFechaModificacion(new Date(System.currentTimeMillis()));
//        persona.setUsuarioModificacion(1);
//        Integer resultado = this.personaDao.insertar(persona);
//        assertTrue(resultado != 0);
//        listaPersonaId.add(resultado);
//        
//        persona.setPersonaId(2);
//        persona.setNombres("Lorem ipsum B nombres");
//        persona.setPrimerApellido("Lorem ipsum B primerApellido");
//        persona.setSegundoApellido("Lorem ipsum B segundoApellido");
//        persona.setCodigo("Lorem ipsum B codigo");
//        persona.setCorreo("Lorem ipsum B correo");
//        persona.setContrasena("Lorem ipsum B contrasena");
//        persona.setFechaCreacion(new Date(System.currentTimeMillis()));
//        persona.setUsuarioCreacion(1);
//        persona.setFechaModificacion(new Date(System.currentTimeMillis()));
//        persona.setUsuarioModificacion(1);
//        resultado = this.personaDao.insertar(persona);
//        assertTrue(resultado != 0);
//        listaPersonaId.add(resultado);
//        
//        persona.setPersonaId(3);
//        persona.setNombres("Lorem ipsum C nombres");
//        persona.setPrimerApellido("Lorem ipsum C primerApellido");
//        persona.setSegundoApellido("Lorem ipsum C segundoApellido");
//        persona.setCodigo("Lorem ipsum C codigo");
//        persona.setCorreo("Lorem ipsum C correo");
//        persona.setContrasena("Lorem ipsum C contrasena");
//        persona.setFechaCreacion(new Date(System.currentTimeMillis()));
//        persona.setUsuarioCreacion(1);
//        persona.setFechaModificacion(new Date(System.currentTimeMillis()));
//        persona.setUsuarioModificacion(1);
//        resultado = this.personaDao.insertar(persona);
//        assertTrue(resultado != 0);
//        listaPersonaId.add(resultado);        
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaPersonaId = new ArrayList<>();
//        insertarPersonas(listaPersonaId);
//        PersonaDto persona = this.personaDao.obtenerPorId(listaPersonaId.get(0));
//        assertEquals(persona.getPersonaId(), listaPersonaId.get(0));
//        
//        persona = this.personaDao.obtenerPorId(listaPersonaId.get(1));
//        assertEquals(persona.getPersonaId(), listaPersonaId.get(1));
//        
//        persona = this.personaDao.obtenerPorId(listaPersonaId.get(2));
//        assertEquals(persona.getPersonaId(), listaPersonaId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaPersonaId = new ArrayList<>();
//        insertarPersonas(listaPersonaId);
//        
//        ArrayList<PersonaDto> listaPersonas = this.personaDao.listarTodos();
//        assertEquals(listaPersonaId.size(), listaPersonas.size());
//        for (Integer i = 0; i < listaPersonaId.size(); i++) {
//            assertEquals(listaPersonaId.get(i), listaPersonas.get(i).getPersonaId());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaPersonaId = new ArrayList<>();
//        insertarPersonas(listaPersonaId);
//        
//        ArrayList<PersonaDto> listaPersonas = this.personaDao.listarTodos();
//        assertEquals(listaPersonaId.size(), listaPersonas.size());
//        for (Integer i = 0; i < listaPersonaId.size(); i++) {
//            // Cambios dummy no nulos
//            this.personaDao.modificar(listaPersonas.get(i));
//        }
//        
//        ArrayList<PersonaDto> listaPersonasModificados = this.personaDao.listarTodos();
//        assertEquals( listaPersonas.size(), listaPersonasModificados.size());
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaPersonaId = new ArrayList<>();
//        insertarPersonas(listaPersonaId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<PersonaDto> listaPersonas = this.personaDao.listarTodos();
//        for (Integer i = 0; i < listaPersonas.size(); i++) {
//            Integer resultado = this.personaDao.eliminar(listaPersonas.get(i));
//            assertNotEquals(0, resultado);
//            PersonaDto persona = this.personaDao.obtenerPorId(listaPersonas.get(i).getPersonaId());
//            assertNull(persona);
//        }
//    }
}
