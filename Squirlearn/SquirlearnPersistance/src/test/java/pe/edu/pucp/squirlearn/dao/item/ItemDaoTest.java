package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.ItemDaoImpl;
import pe.edu.pucp.squirlearn.model.item.CategoriaDto;
import pe.edu.pucp.squirlearn.model.item.ColorDto;
import pe.edu.pucp.squirlearn.model.item.CondicionDto;
import pe.edu.pucp.squirlearn.model.item.EstadoItemDto;
import pe.edu.pucp.squirlearn.model.item.FormatoDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;
import pe.edu.pucp.squirlearn.model.item.SubcategoriaDto;
import pe.edu.pucp.squirlearn.model.item.TamanoDto;

public class ItemDaoTest {

    private ItemDao itemDAO;

    public ItemDaoTest() {
        this.itemDAO = new ItemDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ColorDto color = new ColorDto(); color.setColorId(1);
//        EstadoItemDto estado = new EstadoItemDto(); estado.setEstadoItemId(1);
//        CondicionDto cond = new CondicionDto(); cond.setCondicionId(1);
//        TamanoDto tam = new TamanoDto(); tam.setTamanoId(1);
//        FormatoDto formato = new FormatoDto(); formato.setFormatoId(1);
//        SubcategoriaDto sub = new SubcategoriaDto(); sub.setSubcategoriaId(1);
//        CategoriaDto cat = new CategoriaDto(); cat.setCategoriaId(1);
//
//        ItemDto item = new ItemDto();
//        item.setColor(color);
//        item.setEstadoItem(estado);
//        item.setCondicion(cond);
//        item.setTamano(tam);
//        item.setFormato(formato);
//        item.setSubcategoria(sub);
//        item.setCategoria(cat);
//        item.setNombre("Item de prueba");
//        item.setDescripcion("Descripción de prueba");
//        item.setPrecio(50.0);
//        item.setEsVenta(true);
//        item.setusuarioCreacion("testUser");
//
//        Integer resultado = this.itemDAO.insertar(item);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ItemDto item = this.itemDAO.obtenerPorId(1);
//        if (item != null) {
//            System.out.println(item.getItemId());
//            System.out.println(item.getNombre());
//            System.out.println(item.getPrecio());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<ItemDto> lista = this.itemDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            ItemDto item = lista.get(i);
//            System.out.println("Dato:");
//            System.out.println(item.getItemId());
//            System.out.println(item.getNombre());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ColorDto color = new ColorDto(); color.setColorId(1);
//        EstadoItemDto estado = new EstadoItemDto(); estado.setEstadoItemId(1);
//        CondicionDto cond = new CondicionDto(); cond.setCondicionId(1);
//        TamanoDto tam = new TamanoDto(); tam.setTamanoId(1);
//        FormatoDto formato = new FormatoDto(); formato.setFormatoId(1);
//        SubcategoriaDto sub = new SubcategoriaDto(); sub.setSubcategoriaId(1);
//        CategoriaDto cat = new CategoriaDto(); cat.setCategoriaId(1);
//
//        ItemDto item = new ItemDto();
//        item.setColor(color);
//        item.setEstadoItem(estado);
//        item.setCondicion(cond);
//        item.setTamano(tam);
//        item.setFormato(formato);
//        item.setSubcategoria(sub);
//        item.setCategoria(cat);
//        item.setNombre("Item de prueba");
//        item.setDescripcion("Descripción de prueba");
//        item.setPrecio(50.0);
//        item.setEsVenta(true);
//        item.setusuarioCreacion("testUser");
//        item.setItemId(2);
//        item.setusuarioModificacion("modTest");
//        Integer resultado = this.itemDAO.modificar(item);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ItemDto item = new ItemDto();
//        item.setItemId(1);
//        this.itemDAO.eliminar(item);
//    }
}
