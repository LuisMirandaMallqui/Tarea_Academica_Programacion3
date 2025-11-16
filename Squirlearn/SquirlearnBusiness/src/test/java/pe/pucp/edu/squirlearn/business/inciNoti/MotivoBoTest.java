package pe.pucp.edu.squirlearn.business.inciNoti;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.inciNoti.MotivoDto;

public class MotivoBoTest {

    private MotivoBo motivoBO;

    public MotivoBoTest() {
        this.motivoBO = new MotivoBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<MotivoDto> lista = this.motivoBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getMotivoId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        MotivoDto entidad = this.motivoBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getMotivoId());
//            System.out.println(entidad.getNombre());
//        }
//    }
}
