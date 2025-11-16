package pe.pucp.edu.squirlearn.business.chat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.chat.EstadoMensajeDto;

public class EstadoMensajeBoTest {

    private EstadoMensajeBo estadoMensajeBO;

    public EstadoMensajeBoTest() {
        this.estadoMensajeBO = new EstadoMensajeBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<EstadoMensajeDto> lista = this.estadoMensajeBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getEstadoMsjId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        EstadoMensajeDto entidad = this.estadoMensajeBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getEstadoMsjId());
//            System.out.println(entidad.getNombre());
//        }
//    }
}
