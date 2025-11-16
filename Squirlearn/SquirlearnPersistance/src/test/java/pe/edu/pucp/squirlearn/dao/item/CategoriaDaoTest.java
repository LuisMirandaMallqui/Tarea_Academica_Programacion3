package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.CategoriaDaoImpl;
import pe.edu.pucp.squirlearn.model.item.CategoriaDto;

public class CategoriaDaoTest {

    private CategoriaDao categoriaDAO;

    public CategoriaDaoTest() {
        this.categoriaDAO = new CategoriaDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        CategoriaDto c = new CategoriaDto();
//        c.setNombre("Libros");
//        Integer resultado = this.categoriaDAO.insertar(c);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        CategoriaDto c = this.categoriaDAO.obtenerPorId(1);
//        if (c != null) {
//            System.out.println(c.getCategoriaId());
//            System.out.println(c.getNombre());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<CategoriaDto> lista = this.categoriaDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            CategoriaDto c = lista.get(i);
//            System.out.println("Dato:");
//            System.out.println(c.getCategoriaId());
//            System.out.println(c.getNombre());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        CategoriaDto c = new CategoriaDto();
//        c.setCategoriaId(1);
//        c.setNombre("Libros Mod");
//        Integer resultado = this.categoriaDAO.modificar(c);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        CategoriaDto c = new CategoriaDto();
//        c.setCategoriaId(2);
//        this.categoriaDAO.eliminar(c);
//    }
}
