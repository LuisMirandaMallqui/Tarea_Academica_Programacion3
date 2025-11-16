package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.item.CategoriaDto;

public class CategoriaBoTest {

    private CategoriaBo categoriaBO;

    public CategoriaBoTest() {
        this.categoriaBO = new CategoriaBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<CategoriaDto> lista = this.categoriaBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getCategoriaId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        CategoriaDto entidad = this.categoriaBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getCategoriaId());
//            System.out.println(entidad.getNombre());
//        }
//    }
}
