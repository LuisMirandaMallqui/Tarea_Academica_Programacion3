package pe.pucp.edu.squirlearn.business.inciNoti;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.inciNoti.NotificacionDto;

public class NotificacionBoTest {

    private NotificacionBo notificacionBO;

    public NotificacionBoTest() {
        this.notificacionBO = new NotificacionBo();
    }

//    @Test
//    public void testListarPorPersona() {
//        System.out.println("listarPorPersona");
//        // AJUSTA el ID de persona según tu BD
//        ArrayList<NotificacionDto> lista = this.notificacionBO.listarPorPersona(1,1,5);
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getNotificacionId());
//            System.out.println(lista.get(i).getMensaje());
//            System.out.println(lista.get(i).getFecha());
//            System.out.println(lista.get(i).getPersona().getPersonaId());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        NotificacionDto entidad = this.notificacionBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getNotificacionId());
//            System.out.println(entidad.getMensaje());
//            System.out.println(entidad.getFecha());
//            System.out.println(entidad.getPersona().getPersonaId());
//        }
//    }
    @Test
    public void testInsertar() {
        System.out.println("insertar");
//         Mismos datos de prueba que en NotificacionDaoTest
        Integer resultado = this.notificacionBO.insertar("mnn okfokorgr", 3 ,"121212");
         
        assertTrue(resultado != 0);
    }
}

