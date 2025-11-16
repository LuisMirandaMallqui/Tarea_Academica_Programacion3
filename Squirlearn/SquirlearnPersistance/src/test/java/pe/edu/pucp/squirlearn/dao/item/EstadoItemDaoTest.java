package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.EstadoItemDaoImpl;
import pe.edu.pucp.squirlearn.model.item.EstadoItemDto;

public class EstadoItemDaoTest {

    private EstadoItemDao estadoItemDAO;

    public EstadoItemDaoTest() {
        this.estadoItemDAO = new EstadoItemDaoImpl();
    }
//
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        EstadoItemDto estado = new EstadoItemDto();
//        estado.setNombre("Disponible");
//        Integer resultado = this.estadoItemDAO.insertar(estado);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        EstadoItemDto estado = this.estadoItemDAO.obtenerPorId(1);
//        if (estado != null) {
//            System.out.println(estado.getEstadoItemId());
//            System.out.println(estado.getNombre());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<EstadoItemDto> lista = this.estadoItemDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getEstadoItemId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        EstadoItemDto estado = new EstadoItemDto();
//        estado.setEstadoItemId(1);
//        estado.setNombre("Disponible MOD");
//        Integer resultado = this.estadoItemDAO.modificar(estado);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        EstadoItemDto estado = new EstadoItemDto();
//        estado.setEstadoItemId(2);
//        this.estadoItemDAO.eliminar(estado);
//    }
}
