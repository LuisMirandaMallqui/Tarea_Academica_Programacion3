package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.pucp.edu.squirlearn.business.item.ItemBo;
import pe.edu.pucp.squirlearn.model.item.ItemDto;

public class ItemBoTest {
    
    private ItemBo itemBO;
    
    public ItemBoTest() {
        this.itemBO = new ItemBo();
    }
    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        Integer resultado = this.itemBO.insertar(
//                69.69,                          // precio
//                "Libro de prueba",              // nombre
//                "Descripción de prueba",        // descripcion
//                true,                           // esVenta
//                1,                              // colorId
//                1,                              // condicionId
//                1,                              // tamanoId
//                1,                              // formatoId
//                1,                              // categoriaId
//                1,                              // subcategoriaId
//                "DANIEL"                        // usuarioCreacion
//        );
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        Integer resultado = this.itemBO.modificar(
//                11,                             // id (AJUSTA a uno que exista)
//                99.99,                          // precio
//                "Libro modificado",             // nombre
//                "Descripción modificada",       // descripcion
//                true,                           // esVenta
//                1,                              // colorId
//                1,                              // estadoId
//                1,                              // condicionId
//                1,                              // tamanoId
//                1,                              // formatoId
//                1,                              // categoriaId
//                1,                              // subcategoriaId
//                "usuarioTest",                  // usuario
//                "DANIEL",                       // usuarioCreacion
//                "MOD_TEST"                      // usuarioModificacion
//        );
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        ItemDto item = this.itemBO.obtenerPorId(11); // AJUSTA ID
//        if (item != null) {
//            System.out.println(item.getItemId());
//            System.out.println(item.getNombre());
//            System.out.println(item.getDescripcion());
//            System.out.println(item.getPrecio());
//        }
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos (simulado con obtenerPorId)");
//        ArrayList<ItemDto> lista = new ArrayList<>();
//        ItemDto item = this.itemBO.obtenerPorId(11); // AJUSTA ID
//        if (item != null) {
//            lista.add(item);
//        }
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.print("Dato: ");
//            System.out.println(i);
//            System.out.println(lista.get(i).getItemId());
//            System.out.println(lista.get(i).getNombre());
//            System.out.println(lista.get(i).getPrecio());
//        }
//    }
}
