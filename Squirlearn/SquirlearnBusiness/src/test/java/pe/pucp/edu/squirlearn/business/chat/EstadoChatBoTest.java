package pe.pucp.edu.squirlearn.business.chat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.chat.EstadoChatDto;

public class EstadoChatBoTest {

    private EstadoChatBo estadoChatBO;

    public EstadoChatBoTest() {
        this.estadoChatBO = new EstadoChatBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<EstadoChatDto> lista = this.estadoChatBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getEstadoChatId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        EstadoChatDto entidad = this.estadoChatBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getEstadoChatId());
//            System.out.println(entidad.getNombre());
//        }
//    }
}
