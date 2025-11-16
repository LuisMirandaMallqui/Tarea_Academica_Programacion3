package pe.edu.pucp.squirlearn.dao.inciNoti;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.inciNoti.IncidenciaDaoImpl;
import pe.edu.pucp.squirlearn.model.inciNoti.IncidenciaDto;
import pe.edu.pucp.squirlearn.model.inciNoti.MotivoDto;
import pe.edu.pucp.squirlearn.model.inciNoti.NotificacionDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class IncidenciaDaoTest {

    private IncidenciaDao incidenciaDAO;

    public IncidenciaDaoTest() {
        this.incidenciaDAO = new IncidenciaDaoImpl();
    }
//
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        PersonaDto persona = new PersonaDto();
//        persona.setPersonaId(1);
//        MotivoDto motivo = new MotivoDto();
//        motivo.setMotivoId(1);
//        NotificacionDto noti = new NotificacionDto();
//        noti.setNotificacionId(1);
//
//        IncidenciaDto inc = new IncidenciaDto();
//        inc.setPersona(persona);
//        inc.setMotivo(motivo);
//        inc.setNotificacion(noti);
//        inc.setDescripcion("Incidencia de prueba");
//        inc.setUsuarioCreacion("Pablito");
//        inc.setResuelto(1);
//        Integer resultado = this.incidenciaDAO.insertar(inc);
//        assertTrue(resultado != 0);
//    }

//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        IncidenciaDto inc = this.incidenciaDAO.obtenerPorId(1);
//        if (inc != null) {
//            System.out.println(inc.getIncidenciaId());
//            System.out.println(inc.getDescripcion());
//        }
//    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<IncidenciaDto> lista = this.incidenciaDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            IncidenciaDto inc = lista.get(i);
//            System.out.println("Dato:");
//            System.out.println(inc.getIncidenciaId());
//            System.out.println(inc.getDescripcion());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        PersonaDto persona = new PersonaDto();
//        persona.setPersonaId(1);
//        MotivoDto motivo = new MotivoDto();
//        motivo.setMotivoId(1);
//        NotificacionDto noti = new NotificacionDto();
//        noti.setNotificacionId(10);
//
//        IncidenciaDto inc = new IncidenciaDto();
//        inc.setPersona(persona);
//        inc.setMotivo(motivo);
//        inc.setNotificacion(noti);
//        inc.setDescripcion("Incidencia de prueba");
//        inc.setIncidenciaId(2);
//        inc.setResuelto(0);
//        Integer resultado = this.incidenciaDAO.modificar(inc);
//        assertTrue(resultado != 0);
//    }

//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        IncidenciaDto inc = new IncidenciaDto();
//        inc.setIncidenciaId(2);
//        this.incidenciaDAO.eliminar(inc);
//    }
}
