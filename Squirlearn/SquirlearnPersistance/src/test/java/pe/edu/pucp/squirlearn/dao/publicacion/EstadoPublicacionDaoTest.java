package pe.edu.pucp.squirlearn.dao.publicacion;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.publicacion.EstadoPublicacionDaoImpl;
import pe.edu.pucp.squirlearn.model.publicacion.EstadoPublicacionDto;

public class EstadoPublicacionDaoTest {

    private EstadoPublicacionDao estadoPublicacionDAO;

    public EstadoPublicacionDaoTest() {
        this.estadoPublicacionDAO = new EstadoPublicacionDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        EstadoPublicacionDto e = new EstadoPublicacionDto();
//        e.setNombre("Activa");
//        Integer resultado = this.estadoPublicacionDAO.insertar(e);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        EstadoPublicacionDto e = this.estadoPublicacionDAO.obtenerPorId(1);
//        if (e != null) {
//            System.out.println(e.getEstadoPublicacionId());
//            System.out.println(e.getNombre());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<EstadoPublicacionDto> lista = this.estadoPublicacionDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            EstadoPublicacionDto e = lista.get(i);
//            System.out.println("Dato:");
//            System.out.println(e.getEstadoPublicacionId());
//            System.out.println(e.getNombre());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        EstadoPublicacionDto e = new EstadoPublicacionDto();
//        e.setEstadoPublicacionId(1);
//        e.setNombre("Activa Mod");
//        Integer resultado = this.estadoPublicacionDAO.modificar(e);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        EstadoPublicacionDto e = new EstadoPublicacionDto();
//        e.setEstadoPublicacionId(2);
//        this.estadoPublicacionDAO.eliminar(e);
//    }
}
