package pe.pucp.edu.squirlearn.business.inciNoti;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.pucp.edu.squirlearn.business.inciNoti.IncidenciaBo;
import pe.edu.pucp.squirlearn.model.inciNoti.IncidenciaDto;

public class IncidenciaBoTest {
    
    private IncidenciaBo incidenciaBO;
    
    public IncidenciaBoTest() {
        this.incidenciaBO = new IncidenciaBo();
    }
    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        Integer resultado = this.incidenciaBO.insertar(
//                "Incidencia desde BO", // descripcion
//                1,                     // notificcionId
//                1,                     // personaId
//                1,                     // motivoId
//                1,                     // usuarioSolucion
//                "DANIEL"               // usuarioCreacion
//        );
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        Integer resultado = this.incidenciaBO.modificar(
//                1,                    // id (AJUSTA)
//                "Incidencia modificada BO",
//                1,                     // notificcionId
//                1,                     // personaId
//                1,                     // motivoId
//                1,                     // resuelto (1 = true)
//                2,                     // usuarioSolucion
//                "DANIEL"               // usuarioCreacion
//        );
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        IncidenciaDto inc = this.incidenciaBO.obtenerPorId(11); // AJUSTA
//        if (inc != null) {
//            System.out.println(inc.getIncidenciaId());
//            System.out.println(inc.getDescripcion());
//            System.out.println(inc.getResuelto());
//            if (inc.getPersona() != null) {
//                System.out.println(inc.getPersona().getPersonaId());
//            }
//        }
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos (listarPorResolucion)");
//        ArrayList<IncidenciaDto> lista = this.incidenciaBO.listarPorResolucion(false);
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.print("Dato: ");
//            System.out.println(i);
//            System.out.println(lista.get(i).getIncidenciaId());
//            System.out.println(lista.get(i).getDescripcion());
//            System.out.println(lista.get(i).getResuelto());
//        }
//    }
}
