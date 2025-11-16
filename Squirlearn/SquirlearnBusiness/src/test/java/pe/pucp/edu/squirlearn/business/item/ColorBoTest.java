package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.item.ColorDto;

public class ColorBoTest {

    private ColorBo colorBO;

    public ColorBoTest() {
        this.colorBO = new ColorBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<ColorDto> lista = this.colorBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getColorId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        ColorDto entidad = this.colorBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getColorId());
//            System.out.println(entidad.getNombre());
//        }
//    }
}
