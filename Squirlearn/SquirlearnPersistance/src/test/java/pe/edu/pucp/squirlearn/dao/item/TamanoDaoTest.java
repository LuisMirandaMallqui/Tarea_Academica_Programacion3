package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.TamanoDaoImpl;
import pe.edu.pucp.squirlearn.model.item.TamanoDto;

public class TamanoDaoTest {

    private TamanoDao tamanoDAO;

    public TamanoDaoTest() {
        this.tamanoDAO = new TamanoDaoImpl();
    }
//
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        TamanoDto t = new TamanoDto();
//        t.setNombre("Tamaño prueba");
//        Integer resultado = this.tamanoDAO.insertar(t);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        TamanoDto t = this.tamanoDAO.obtenerPorId(1);
//        if (t != null) {
//            System.out.println(t.getTamanoId());
//            System.out.println(t.getNombre());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<TamanoDto> lista = this.tamanoDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getTamanoId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        TamanoDto t = new TamanoDto();
//        t.setTamanoId(1);
//        t.setNombre("Tamaño MOD");
//        Integer resultado = this.tamanoDAO.modificar(t);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        TamanoDto t = new TamanoDto();
//        t.setTamanoId(2);
//        this.tamanoDAO.eliminar(t);
//    }
}
