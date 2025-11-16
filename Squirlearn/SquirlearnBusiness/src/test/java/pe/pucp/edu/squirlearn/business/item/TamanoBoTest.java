package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.item.TamanoDto;

public class TamanoBoTest {

    private TamanoBo tamanoBO;

    public TamanoBoTest() {
        this.tamanoBO = new TamanoBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<TamanoDto> lista = this.tamanoBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getTamanoId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        TamanoDto entidad = this.tamanoBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getTamanoId());
//            System.out.println(entidad.getNombre());
//        }
//    }
}
