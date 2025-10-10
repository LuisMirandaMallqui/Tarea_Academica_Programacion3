
package pe.pucp.edu.squirlearn.business.publicacion;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.publicacion.HistoriaPublicacionDao;
import pe.edu.pucp.squirlearn.daoImpl.publicacion.HistoriaPublicacionDaoImpl;
import pe.edu.pucp.squirlearn.model.publicacion.HistoriaPublicacionDto;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionDto;

public class HistoriaPublicacionBo {
    
    private HistoriaPublicacionDao historiaPublicacionDao;
    
    public HistoriaPublicacionBo(){
        this.historiaPublicacionDao = new HistoriaPublicacionDaoImpl();
    }
    
    public Integer insertar(Integer publicacionId, Integer modificadorId){
        HistoriaPublicacionDto historiaPublicacionDto = new HistoriaPublicacionDto();
        PublicacionDto publicacionDto = new PublicacionDto();
        publicacionDto.setPublicacionId(publicacionId);
        historiaPublicacionDto.setPublicacion(publicacionDto);
        historiaPublicacionDto.setUsuarioModificacion(modificadorId);
        return this.historiaPublicacionDao.insertar(historiaPublicacionDto);
    }
    
    public ArrayList<HistoriaPublicacionDto> listarTodos(){
        return this.historiaPublicacionDao.listarTodos();
    }
    
    public HistoriaPublicacionDto obtenerPorId(Integer id){
        return this.historiaPublicacionDao.obtenerPorId(id);
    }
    
    
}
