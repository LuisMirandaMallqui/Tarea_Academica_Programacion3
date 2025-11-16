package pe.edu.pucp.squirlearn.dao.chat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.chat.EstadoMensajeDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.EstadoMensajeDto;

public class EstadoMensajeDaoTest {

    private EstadoMensajeDao estadoMensajeDAO;

    public EstadoMensajeDaoTest() {
        this.estadoMensajeDAO = new EstadoMensajeDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        EstadoMensajeDto estado = new EstadoMensajeDto();
//        estado.setNombre("Enviado");
//        Integer resultado = this.estadoMensajeDAO.insertar(estado);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        EstadoMensajeDto estado = this.estadoMensajeDAO.obtenerPorId(1);
//        if (estado != null) {
//            System.out.println(estado.getEstadoMsjId());
//            System.out.println(estado.getNombre());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<EstadoMensajeDto> lista = this.estadoMensajeDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getEstadoMsjId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        EstadoMensajeDto estado = new EstadoMensajeDto();
//        estado.setEstadoMsjId(1);
//        estado.setNombre("afda");
//        Integer resultado = this.estadoMensajeDAO.modificar(estado);
//        assertTrue(resultado != 0);
//    }

}
