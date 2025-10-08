package pe.edu.pucp.squirlearn.dao.inciNoti;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.inciNoti.IncidenciaDaoImpl;
import pe.edu.pucp.squirlearn.model.inciNoti.IncidenciaDto;

public class IncidenciaDaoTest {
    
    private IncidenciaDao incidenciaDao;    
    
    public IncidenciaDaoTest() {
        this.incidenciaDao = new IncidenciaDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaIncidenciaId = new ArrayList<>();
        insertarIncidencias(listaIncidenciaId);
        eliminarTodo();
    }
    
    private void insertarIncidencias(ArrayList<Integer> listaIncidenciaId) {
        IncidenciaDto incidencia = new IncidenciaDto();
        incidencia.setIncidenciaDto(1);
        incidencia.setDescripcion("Lorem ipsum descripcion");
        incidencia.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
        incidencia.setFechaSolucion(new java.sql.Date(System.currentTimeMillis()));
        incidencia.setUsuarioCreacion(1);
        incidencia.setUsuarioSolucion(1);
        incidencia.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
        incidencia.setUsuarioModificacion(1);
        Integer resultado = this.incidenciaDao.insertar(incidencia);
        assertTrue(resultado != 0);
        listaIncidenciaId.add(resultado);
        
        incidencia.setIncidenciaDto(1);
        incidencia.setDescripcion("Lorem ipsum B descripcion");
        incidencia.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
        incidencia.setFechaSolucion(new java.sql.Date(System.currentTimeMillis()));
        incidencia.setUsuarioCreacion(1);
        incidencia.setUsuarioSolucion(1);
        incidencia.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
        incidencia.setUsuarioModificacion(1);
        resultado = this.incidenciaDao.insertar(incidencia);
        assertTrue(resultado != 0);
        listaIncidenciaId.add(resultado);
        
        incidencia.setIncidenciaDto(1);
        incidencia.setDescripcion("Lorem ipsum C descripcion");
        incidencia.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
        incidencia.setFechaSolucion(new java.sql.Date(System.currentTimeMillis()));
        incidencia.setUsuarioCreacion(1);
        incidencia.setUsuarioSolucion(1);
        incidencia.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
        incidencia.setUsuarioModificacion(1);
        resultado = this.incidenciaDao.insertar(incidencia);
        assertTrue(resultado != 0);
        listaIncidenciaId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        
    }
    
    @Test
    public void testListarTodos() {
        
        
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaIncidenciaId = new ArrayList<>();
        insertarIncidencias(listaIncidenciaId);
        
        ArrayList<IncidenciaDto> listaIncidencias = this.incidenciaDao.listarTodos();
        assertEquals(listaIncidenciaId.size(), listaIncidencias.size());
        for (Integer i = 0; i < listaIncidenciaId.size(); i++) {
            // Cambios dummy no nulos
            this.incidenciaDao.modificar(listaIncidencias.get(i));
        }
        
        ArrayList<IncidenciaDto> listaIncidenciasModificados = this.incidenciaDao.listarTodos();
        assertEquals( listaIncidencias.size(), listaIncidenciasModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaIncidenciaId = new ArrayList<>();
        insertarIncidencias(listaIncidenciaId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){   
        
    }
}
