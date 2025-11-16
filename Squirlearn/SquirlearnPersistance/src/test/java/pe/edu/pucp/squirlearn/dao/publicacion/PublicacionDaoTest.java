package pe.edu.pucp.squirlearn.dao.publicacion;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.publicacion.PublicacionDaoImpl;
import pe.edu.pucp.squirlearn.model.item.ItemDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import pe.edu.pucp.squirlearn.model.publicacion.EstadoPublicacionDto;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionDto;

public class PublicacionDaoTest {

    private PublicacionDao publicacionDAO;

    public PublicacionDaoTest() {
        this.publicacionDAO = new PublicacionDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        EstadoPublicacionDto estado = new EstadoPublicacionDto();
//        estado.setEstadoPublicacionId(1);
//        ItemDto item = new ItemDto();
//        item.setItemId(1);
//        PersonaDto persona = new PersonaDto();
//        persona.setPersonaId(1);
//
//        PublicacionDto p = new PublicacionDto();
//        p.setEstadoPublicacion(estado);
//        p.setItem(item);
//        p.setPersona(persona);
//        p.setusuarioCreacion("Holas");
//        p.setFechaAlta("2025-02-12");
//        p.setFechaBaja(null);
//
//        Integer resultado = this.publicacionDAO.insertar(p);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        PublicacionDto p = this.publicacionDAO.obtenerPorId(1);
//        if (p != null) {
//            System.out.println(p.getPublicacionId());
//            System.out.println(p.getFechaAlta());
//            System.out.println(p.getFechaBaja());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<PublicacionDto> lista = this.publicacionDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            PublicacionDto p = lista.get(i);
//            System.out.println("Dato:");
//            System.out.println(p.getPublicacionId());
//            System.out.println(p.getFechaAlta());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        EstadoPublicacionDto estado = new EstadoPublicacionDto();
//        estado.setEstadoPublicacionId(1);
//        ItemDto item = new ItemDto();
//        item.setItemId(1);
//        PersonaDto persona = new PersonaDto();
//        persona.setPersonaId(1);
//
//        PublicacionDto p = new PublicacionDto();
//        p.setEstadoPublicacion(estado);
//        p.setItem(item);
//        p.setPersona(persona);
//        p.setFechaAlta("2025-02-12");
//        p.setPublicacionId(1);
//        p.setFechaBaja("2025-03-01");
//        Integer resultado = this.publicacionDAO.modificar(p);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        PublicacionDto p = new PublicacionDto();
//        p.setPublicacionId(2);
//        this.publicacionDAO.eliminar(p);
//    }
}
