package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.item.SubcategoriaDto;

public class SubcategoriaBoTest {

    private SubcategoriaBo subcategoriaBO;

    public SubcategoriaBoTest() {
        this.subcategoriaBO = new SubcategoriaBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<SubcategoriaDto> lista = this.subcategoriaBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getSubcategoriaId());
//            System.out.println(lista.get(i).getNombre());
//            System.out.println(lista.get(i).getCategoria().getCategoriaId());
//        }
//    }
//
//    @Test
//    public void testListarPorCategoria() {
//        System.out.println("listarPorCategoria");
//        // AJUSTA el ID de categoría según tu BD
//        ArrayList<SubcategoriaDto> lista = this.subcategoriaBO.listarPorCategoria(1);
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getSubcategoriaId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        SubcategoriaDto entidad = this.subcategoriaBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getNombre());
//            System.out.println(entidad.getSubcategoriaId());
//            System.out.println(entidad.getCategoria().getCategoriaId());
//        }
//    }
}
