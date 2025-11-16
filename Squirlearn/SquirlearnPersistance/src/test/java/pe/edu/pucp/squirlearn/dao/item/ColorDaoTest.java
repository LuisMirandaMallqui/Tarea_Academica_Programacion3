package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.ColorDaoImpl;
import pe.edu.pucp.squirlearn.model.item.ColorDto;

public class ColorDaoTest {

    private ColorDao colorDAO;

    public ColorDaoTest() {
        this.colorDAO = new ColorDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ColorDto color = new ColorDto();
//        color.setNombre("Rojo Prueba");
//        Integer resultado = this.colorDAO.insertar(color);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        // AJUSTA este ID a uno que exista
//        ColorDto color = this.colorDAO.obtenerPorId(1);
//        if (color != null) {
//            System.out.println(color.getColorId());
//            System.out.println(color.getNombre());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<ColorDto> lista = this.colorDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getColorId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ColorDto color = new ColorDto();
//        // AJUSTA este ID a uno que exista
//        color.setColorId(1);
//        color.setNombre("Rojo Modificado");
//        Integer resultado = this.colorDAO.modificar(color);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ColorDto color = new ColorDto();
//        // AJUSTA este ID al que quieras borrar
//        color.setColorId(2);
//        this.colorDAO.eliminar(color);
//    }
}
