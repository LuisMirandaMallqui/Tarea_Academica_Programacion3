package pe.edu.pucp.squirlearn.dao.persona;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.persona.PersonaDaoImpl;
import pe.edu.pucp.squirlearn.model.persona.EstadoPersonaDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class PersonaDaoTest {
    
    private PersonaDao personaDAO;    
    
    public PersonaDaoTest() {
        this.personaDAO = new PersonaDaoImpl();        
    }
    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        EstadoPersonaDto estado= new EstadoPersonaDto();
//        estado.setEstadoPersonaId(1);
//        PersonaDto persona = new PersonaDto();
//        persona.setEstadoPersona(estado);
//        persona.setNombres("Juan");
//        persona.setPrimerApellido("Pérez");
//        persona.setSegundoApellido("Prueba");
//        persona.setCodigo("20250001");
//        persona.setCorreo("juan.perez.prueba@pucp.edu.pe");
//        persona.setContrasena("ContrasenaSegura123");
//        persona.setUltimaActividad("2025-2-12");
//        persona.setusuarioCreacion("jueanitoPerez");   // ahora es String
//        
//        Integer resultado = this.personaDAO.insertar(persona);
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        
////         AJUSTA este ID a uno que exista en tu BD
//        PersonaDto persona = this.personaDAO.obtenerPorId(1);
//        
//        if (persona != null) {
//            System.out.println(persona.getPersonaId());
//            System.out.println(persona.getNombres());
//            System.out.println(persona.getPrimerApellido());
//            System.out.println(persona.getSegundoApellido());
//            System.out.println(persona.getCodigo());
//            System.out.println(persona.getCorreo());
//            System.out.println(persona.getUltimaActividad());
//            System.out.println(persona.getusuarioCreacion());
//        }
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<PersonaDto> listaPersonas = this.personaDAO.listarTodos();
//        for (Integer i = 0; i < listaPersonas.size(); i++) {
//            
//            System.out.println("Dato: ");
//            System.out.println(listaPersonas.get(i).getPersonaId());
//            System.out.println(listaPersonas.get(i).getNombres());
//            System.out.println(listaPersonas.get(i).getCorreo());
//            for(int j=0; j<listaPersonas.get(i).getRolPersona().size();j++){
//                System.out.println(listaPersonas.get(i).getRolPersona().get(j).getRolPersonaId());
//                System.out.println(listaPersonas.get(i).getRolPersona().get(j).getNombre());
//            }
//        }
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        EstadoPersonaDto estado= new EstadoPersonaDto();
//        estado.setEstadoPersonaId(1);
//        PersonaDto persona = new PersonaDto();
//        persona.setEstadoPersona(estado);
////         AJUSTA este ID a uno que realmente exista
//        persona.setPersonaId(10);
//        persona.setNombres("Nombre Modificado");
//        persona.setPrimerApellido("Apellido Mod");
//        persona.setSegundoApellido("Apellido Mod2");
//        persona.setCodigo("20250001");
//        persona.setCorreo("nombre.modificado@pucp.edu.pe");
//        persona.setContrasena("NuevaContrasena123");
//        persona.setUltimaActividad("2025-2-12");
//        persona.setusuarioCreacion(null);             // similar a lo que haces en alquiler
//        persona.setusuarioModificacion("Holiwis");
//        
//        Integer resultado = this.personaDAO.modificar(persona);
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        
//        PersonaDto persona = new PersonaDto();
//        // AJUSTA este ID al que quieras borrar
//        persona.setPersonaId(11);
//        this.personaDAO.eliminar(persona);
//    }
}
