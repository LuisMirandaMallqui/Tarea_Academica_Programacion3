package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

import pe.edu.pucp.softinv.daoImpl.PublicacionDAOImpl;
import pe.edu.pucp.softinv.daoImpl.EstadoPublicacionDAOImpl;
import pe.edu.pucp.softinv.daoImpl.PersonasDAOImpl;
import pe.edu.pucp.softinv.model.PublicacionDTO;
import pe.edu.pucp.softinv.model.EstadoPublicacionDTO;
import pe.edu.pucp.softinv.model.PersonasDTO;
import pe.edu.pucp.softinv.model.MaterialDTO;

@TestMethodOrder(OrderAnnotation.class)
public class PublicacionDAOTest {
    private final PublicacionDAO dao;
    private final PersonasDAO personasDAO = new PersonasDAOImpl();
    private final EstadoPublicacionDAO estadoDAO = new EstadoPublicacionDAOImpl();
    private static Integer pubId;
    private static Integer personaId;
    private static Integer estadoId;

    public PublicacionDAOTest() {
        this.dao = new PublicacionDAOImpl();
    }

    private Integer ensurePersona() {
        if (personaId != null) return personaId;
        PersonasDTO p = new PersonasDTO();
        p.setEsAdministador(Boolean.FALSE);
        p.setNombres("Mario");
        p.setPrimerApellido("Vega");
        p.setSegundoApellido("Salas");
        p.setCorreoElectronico("mario.vega@pucp.edu.pe");
        p.setCodigoUniversitario("20206666");
        p.setTipoDocumento("DNI");
        p.setNumeroDocumento("66778899");
        p.setContraseña("Pass123!");
        personaId = personasDAO.insertar(p);
        return personaId;
    }

    private Integer ensureEstado() {
        if (estadoId != null) return estadoId;
        EstadoPublicacionDTO e = new EstadoPublicacionDTO();
        e.setDescripcion("Activa");
        e.setFechaIngreso(LocalDateTime.now());
        estadoId = estadoDAO.insertar(e);
        return estadoId;
    }

    @Test @Order(1)
    public void testInsertar() {
        PersonasDTO persona = new PersonasDTO();
        persona.setPersonaId(ensurePersona());

        EstadoPublicacionDTO estado = new EstadoPublicacionDTO();
        estado.setEstadoPublicacionId(ensureEstado());

        MaterialDTO mat = new MaterialDTO();
        mat.setMaterialId(1); // Debe existir MATERIAL con ID=1

        PublicacionDTO p = new PublicacionDTO();
        p.setMaterialId(mat);
        p.setEstadoPublicacionId(estado);
        p.setPersonaId(persona);
        p.setValoracion(5);
        p.setFecha(LocalDateTime.now());
        p.setPrecio(15.90);

        Integer id = dao.insertar(p);
        assertNotNull(id); assertTrue(id > 0);
        pubId = id;
    }

    @Test @Order(2)
    public void testObtenerPorId() {
        PublicacionDTO p = dao.obtenerPorId(pubId);
        assertNotNull(p);
        assertEquals(5, p.getValoracion());
    }

    @Test @Order(3)
    public void testModificar() {
        PublicacionDTO p = dao.obtenerPorId(pubId);
        p.setValoracion(4);
        Integer res = dao.modificar(p);
        assertTrue(res > 0);
        assertEquals(4, dao.obtenerPorId(pubId).getValoracion());
    }

    @Test @Order(4)
    public void testListarTodos() {
        ArrayList<PublicacionDTO> lista = dao.listarTodos();
        assertNotNull(lista);
        assertTrue(lista.size() > 0);
    }

    @Test @Order(5)
    public void testEliminar() {
        PublicacionDTO p = new PublicacionDTO();
        p.setPublicacionId(pubId);
        Integer res = dao.eliminar(p);
        assertTrue(res > 0);
    }
}
