
package pe.pucp.edu.squirlearn.business.publicacion;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.publicacion.EstadoPublicacionDao;
import pe.edu.pucp.squirlearn.daoImpl.publicacion.EstadoPublicacionDaoImpl;
import pe.edu.pucp.squirlearn.model.publicacion.EstadoPublicacionDto;


public class EstadoPublicacionBo {
    
    private EstadoPublicacionDao estadoPublicacionDao;
    
    public EstadoPublicacionBo(){
        this.estadoPublicacionDao = new EstadoPublicacionDaoImpl();
    }
    
    public ArrayList<EstadoPublicacionDto> listarTodos(){
        return this.estadoPublicacionDao.listarTodos();
    }
    
    public EstadoPublicacionDto obtenerPorId(Integer id){
        return this.estadoPublicacionDao.obtenerPorId(id);
    }
    
    public Integer obtenerId(String nombreMonedaBuscada ){
        
        ArrayList<EstadoPublicacionDto> lista = estadoPublicacionDao.listarTodos();
        EstadoPublicacionDto encontrado = lista.stream()
            .filter(m -> (m.getNombre().toUpperCase()).equalsIgnoreCase(nombreMonedaBuscada))
            .findFirst()
            .orElse(null);
                
        return encontrado.getEstadoPublicacionId();
    }
    
}
