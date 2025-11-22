package pe.pucp.edu.squirlearn.business.persona;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.db.util.Cifrado;
import pe.pucp.edu.squirlearn.business.persona.PersonaBo;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class PersonaBoTest {
    
    private PersonaBo personaBO;
    
    public PersonaBoTest() {
        this.personaBO = new PersonaBo();
    }
    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        Integer resultado = this.personaBO.insertar(
//                "Juan",
//                "Pérez",
//                "Prueba",
//                "12345678",
//                "juan.perez.prueba@pucp.edu.pe",
//                "luis",
//                "juanitoPerez",
//                "2025-02-12"
//        );
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        Integer resultado = this.personaBO.modificar(
//                11,                     // AJUSTA este ID a uno que exista
//                "Nombre Modificado",
//                "Apellido Mod",
//                "Apellido Mod2",
//                "20250001",
//                "nombre.modificado@pucp.edu.pe",
//                "NuevaContrasena123",
//                1,                      // estadoId
//                "juanitoPerez",
//                "Holiwis",
//                "2025-12-31"
//        );
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        PersonaDto persona = this.personaBO.obtenerPorId(1); // AJUSTA ID
//        if (persona != null) {
//            System.out.println(persona.getPersonaId());
//            System.out.println(persona.getNombres());
//            System.out.println(persona.getPrimerApellido());
//            System.out.println(persona.getSegundoApellido());
//            System.out.println(persona.getCodigo());
//            System.out.println(persona.getCorreo());
//            System.out.println(persona.getRolPersona().get(0).getNombre());
//            System.out.println(persona.getUltimaActividad());
//            System.out.println(persona.getusuarioCreacion());
//        }
//    }
//    @Test
//    public void logIn() {
//        System.out.println("login");
//        PersonaDto persona = this.personaBO.logIn("juan.perez.prueba@pucp.edu.pe","luis"); // AJUSTA ID
//        if (persona != null) {
//            System.out.println(persona.getPersonaId());
//            System.out.println(persona.getNombres());
//            System.out.println(persona.getPrimerApellido());
//            System.out.println(persona.getSegundoApellido());
//            System.out.println(persona.getCodigo());
//            System.out.println(persona.getCorreo());
//            System.out.println(persona.getRolPersona().get(0).getNombre());
//            System.out.println(persona.getUltimaActividad());
//            System.out.println(persona.getusuarioCreacion());
//        }
//    }   
////    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<PersonaDto> lista=personaBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.print("Dato: ");
//            System.out.println(i);
//            System.out.println(lista.get(i).getPersonaId());
//            System.out.println(lista.get(i).getNombres());
//            System.out.println(lista.get(i).getCorreo());
//            for(int j=0; j<lista.get(i).getRolPersona().size();j++){
//                System.out.println(lista.get(i).getRolPersona().get(j).getRolPersonaId());
//                System.out.println(lista.get(i).getRolPersona().get(j).getNombre());
//            }
//        }
//    }
}
