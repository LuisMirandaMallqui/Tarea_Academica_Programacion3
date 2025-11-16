package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.SubcategoriaDaoImpl;
import pe.edu.pucp.squirlearn.model.item.CategoriaDto;
import pe.edu.pucp.squirlearn.model.item.SubcategoriaDto;

public class SubcategoriaDaoTest {

    private SubcategoriaDao subcategoriaDAO;

    public SubcategoriaDaoTest() {
        this.subcategoriaDAO = new SubcategoriaDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        CategoriaDto categoria = new CategoriaDto();
//        categoria.setCategoriaId(1);
//
//        SubcategoriaDto sub = new SubcategoriaDto();
//        sub.setNombre("Subcategoria prueba");
//        sub.setCategoria(categoria);
//
//        Integer resultado = this.subcategoriaDAO.insertar(sub);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        SubcategoriaDto sub = this.subcategoriaDAO.obtenerPorId(1);
//        if (sub != null) {
//            System.out.println(sub.getSubcategoriaId());
//            System.out.println(sub.getNombre());
//            if (sub.getCategoria() != null) {
//                System.out.println(sub.getCategoria().getCategoriaId());
//            }
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<SubcategoriaDto> lista = this.subcategoriaDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            SubcategoriaDto sub = lista.get(i);
//            System.out.println("Dato:");
//            System.out.println(sub.getSubcategoriaId());
//            System.out.println(sub.getNombre());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        CategoriaDto categoria = new CategoriaDto();
//        categoria.setCategoriaId(1);
//
//        SubcategoriaDto sub = new SubcategoriaDto();
//        sub.setSubcategoriaId(1); // AJUSTAR
//        sub.setNombre("Subcategoria MOD");
//        sub.setCategoria(categoria);
//
//        Integer resultado = this.subcategoriaDAO.modificar(sub);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        SubcategoriaDto sub = new SubcategoriaDto();
//        sub.setSubcategoriaId(2);
//        this.subcategoriaDAO.eliminar(sub);
//    }
}
