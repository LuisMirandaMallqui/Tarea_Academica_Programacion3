package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.FormatoDaoImpl;
import pe.edu.pucp.squirlearn.model.item.FormatoDto;

public class FormatoDaoTest {

    private FormatoDao formatoDAO;

    public FormatoDaoTest() {
        this.formatoDAO = new FormatoDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        FormatoDto formato = new FormatoDto();
//        formato.setNombre("Físico");
//        Integer resultado = this.formatoDAO.insertar(formato);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        FormatoDto formato = this.formatoDAO.obtenerPorId(1);
//        if (formato != null) {
//            System.out.println(formato.getFormatoId());
//            System.out.println(formato.getNombre());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<FormatoDto> lista = this.formatoDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getFormatoId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        FormatoDto formato = new FormatoDto();
//        formato.setFormatoId(1);
//        formato.setNombre("Físico MOD");
//        Integer resultado = this.formatoDAO.modificar(formato);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        FormatoDto formato = new FormatoDto();
//        formato.setFormatoId(2);
//        this.formatoDAO.eliminar(formato);
//    }
}
